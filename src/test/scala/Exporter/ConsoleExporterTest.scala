package Exporter

import Image.AsciiImage
import Image.Pixel.AsciiValue
import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream
import java.lang.System.lineSeparator

class ConsoleExporterTest extends FunSuite{

  test("[Console Exporter] Export Image to Console") {
    val ascii2x3Image: AsciiImage = new AsciiImage(2, 3)
      .setPixel(AsciiValue('t'), 0, 0)
      .setPixel(AsciiValue('e'), 0, 1)
      .setPixel(AsciiValue('s'), 0, 2)
      .setPixel(AsciiValue('t'), 1, 0)
      .setPixel(AsciiValue('e'), 1, 1)
      .setPixel(AsciiValue('d'), 1, 2)

    val exportedImage = "tes" + lineSeparator + "ted" + lineSeparator

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      ConsoleExporter.`export`(ascii2x3Image)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
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
    // Verify that it is not empty
    assert(out.size() == 0)
  }
}
