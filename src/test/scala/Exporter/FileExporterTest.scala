package Exporter

import Image.AsciiImage
import Image.Pixel.AsciiValue
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

import java.io.{File, FileInputStream, IOException}
import scala.io.Source

class FileExporterTest extends FunSuite {
  test("[File Exporter] Export Ascii Image to File") {
    val ascii2x3Image: AsciiImage = new AsciiImage(2, 3)
      .setPixel(AsciiValue('t'), 0, 0)
      .setPixel(AsciiValue('e'), 0, 1)
      .setPixel(AsciiValue('s'), 0, 2)
      .setPixel(AsciiValue('t'), 1, 0)
      .setPixel(AsciiValue('e'), 1, 1)
      .setPixel(AsciiValue('d'), 1, 2)
    val exportedImage = "tested"

    val exporter = new FileExporter(new File("./images/ascii/converted.txt"))
    exporter.`export`(ascii2x3Image)

    val source = Source.fromFile("./images/ascii/converted.txt")
    var wholeSource = ""
    for (line <- source.getLines()) {
      wholeSource = wholeSource.concat(line)
    }
    source.close()
    assert(wholeSource == exportedImage)
  }

  test("[File Exporter] Export Ascii Image to Corrupted File") {
    val mockFile = mock[File]
    when(mockFile.canWrite).thenReturn(false)
    assertThrows[IOException](new FileExporter(mockFile))
  }
}
