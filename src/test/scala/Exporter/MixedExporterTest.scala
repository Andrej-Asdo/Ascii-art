package Exporter

import Image.AsciiImage
import Image.Pixel.AsciiValue
import org.mockito.MockitoSugar.{mock, verifyZeroInteractions, when}
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, File}
import java.lang.System.lineSeparator
import scala.io.Source

class MixedExporterTest extends FunSuite{
  test("[Mixed Exporter] Export with just one exporter") {
    val ascii2x3Image: AsciiImage = mock[AsciiImage]
    when(ascii2x3Image.getHeight).thenReturn(2)
    when(ascii2x3Image.getWidth).thenReturn(3)
    when(ascii2x3Image.getPixel(0, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(0, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(0, 2)).thenReturn(AsciiValue('s'))
    when(ascii2x3Image.getPixel(1, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(1, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(1, 2)).thenReturn(AsciiValue('d'))

    val exportedImage = "tes" + lineSeparator + "ted" + lineSeparator

    val exporter = new MixedExporter(List[Exporter] {ConsoleExporter})

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      exporter.`export`(ascii2x3Image)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
    assert(out.toString() == exportedImage)
  }

  test("[Mixed Exporter] Export with 2 same exporters") {
    val ascii2x3Image: AsciiImage = mock[AsciiImage]
    when(ascii2x3Image.getHeight).thenReturn(2)
    when(ascii2x3Image.getWidth).thenReturn(3)
    when(ascii2x3Image.getPixel(0, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(0, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(0, 2)).thenReturn(AsciiValue('s'))
    when(ascii2x3Image.getPixel(1, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(1, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(1, 2)).thenReturn(AsciiValue('d'))

    val exportedImage = "tes" + lineSeparator + "ted" + lineSeparator +
                        "tes" + lineSeparator + "ted" + lineSeparator

    val exporter = new MixedExporter(List[Exporter] (
      ConsoleExporter,
      ConsoleExporter
    ))

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      exporter.`export`(ascii2x3Image)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
    assert(out.toString() == exportedImage)
  }

  test("[Mixed Exporter] Export with different exporters") {
    val ascii2x3Image: AsciiImage = mock[AsciiImage]
    when(ascii2x3Image.getHeight).thenReturn(2)
    when(ascii2x3Image.getWidth).thenReturn(3)
    when(ascii2x3Image.getPixel(0, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(0, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(0, 2)).thenReturn(AsciiValue('s'))
    when(ascii2x3Image.getPixel(1, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(1, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(1, 2)).thenReturn(AsciiValue('d'))

    val exportedImage = "tes" + lineSeparator + "ted" + lineSeparator

    val exporter = new MixedExporter(List[Exporter](
      ConsoleExporter,
      new FileExporter(new File("./images/ascii/converted.txt"))
    ))

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      exporter.`export`(ascii2x3Image)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
    assert(out.toString() == exportedImage)

    // Verify file
    val source = Source.fromFile("./images/ascii/converted.txt")
    var wholeSource = ""
    for (line <- source.getLines()) {
      wholeSource = wholeSource.concat(line + lineSeparator)
    }
    source.close()
    assert(wholeSource == exportedImage)
  }

  test("[Mixed Exporter] Export with No Filters") {
    val ascii2x3Image: AsciiImage = mock[AsciiImage]

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    val exporter = new MixedExporter(List[Exporter]())
    // Run command
    Console.withOut(out) {
      exporter.`export`(ascii2x3Image)
    }

    // Verify no interaction with image
    verifyZeroInteractions(ascii2x3Image)
    // Verify that it is empty
    assert(out.size() == 0)
  }
}
