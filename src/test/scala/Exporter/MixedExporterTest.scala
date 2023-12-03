package Exporter

import Image.AsciiImage
import Image.Pixel.AsciiValue
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, File}
import java.lang.System.lineSeparator
import scala.io.Source

class MixedExporterTest extends FunSuite{
  test("[Mixed Exporter] Export with just one exporter") {
    val ascii2x3Image: AsciiImage = new AsciiImage(2, 3)
      .setPixel(AsciiValue('t'), 0, 0)
      .setPixel(AsciiValue('e'), 0, 1)
      .setPixel(AsciiValue('s'), 0, 2)
      .setPixel(AsciiValue('t'), 1, 0)
      .setPixel(AsciiValue('e'), 1, 1)
      .setPixel(AsciiValue('d'), 1, 2)

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
    val ascii2x3Image: AsciiImage = new AsciiImage(2, 3)
      .setPixel(AsciiValue('t'), 0, 0)
      .setPixel(AsciiValue('e'), 0, 1)
      .setPixel(AsciiValue('s'), 0, 2)
      .setPixel(AsciiValue('t'), 1, 0)
      .setPixel(AsciiValue('e'), 1, 1)
      .setPixel(AsciiValue('d'), 1, 2)

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
    val ascii2x3Image: AsciiImage = new AsciiImage(2, 3)
      .setPixel(AsciiValue('t'), 0, 0)
      .setPixel(AsciiValue('e'), 0, 1)
      .setPixel(AsciiValue('s'), 0, 2)
      .setPixel(AsciiValue('t'), 1, 0)
      .setPixel(AsciiValue('e'), 1, 1)
      .setPixel(AsciiValue('d'), 1, 2)

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
}
