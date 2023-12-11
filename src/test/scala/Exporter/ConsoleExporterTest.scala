package Exporter

import Image.AsciiImage
import Image.Pixel.AsciiValue
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream
import java.lang.System.lineSeparator

class ConsoleExporterTest extends FunSuite{

  test("[Console Exporter] Export Image to Console") {
    val ascii2x3Image: AsciiImage = mock[AsciiImage]
    when(ascii2x3Image.getHeight).thenReturn(2)
    when(ascii2x3Image.getWidth).thenReturn(3)
    when(ascii2x3Image.getPixel(0,0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(0,1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(0,2)).thenReturn(AsciiValue('s'))
    when(ascii2x3Image.getPixel(1,0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(1,1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(1,2)).thenReturn(AsciiValue('d'))

    val exportedImage = "tes" + lineSeparator + "ted" + lineSeparator

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      ConsoleExporter.`export`(ascii2x3Image)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
    // Verify correct export
    assert(out.toString() == exportedImage)
  }

  test("[Console Exporter] Test Empty Image") {
    val asciiImage: AsciiImage = new AsciiImage(0,0)

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      ConsoleExporter.`export`(asciiImage)
    }
    // Verify that it is empty
    assert(out.size() == 0)
  }
}
