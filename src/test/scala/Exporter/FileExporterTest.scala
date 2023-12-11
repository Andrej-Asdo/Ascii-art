package Exporter

import Image.AsciiImage
import Image.Pixel.AsciiValue
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

import java.io.{File, FileInputStream, IOException}
import scala.io.Source

class FileExporterTest extends FunSuite {
  test("[File Exporter] Export Ascii Image to File") {
    // Mock the Export Image
    val ascii2x3Image: AsciiImage = mock[AsciiImage]
    when(ascii2x3Image.getHeight).thenReturn(2)
    when(ascii2x3Image.getWidth).thenReturn(3)
    when(ascii2x3Image.getPixel(0, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(0, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(0, 2)).thenReturn(AsciiValue('s'))
    when(ascii2x3Image.getPixel(1, 0)).thenReturn(AsciiValue('t'))
    when(ascii2x3Image.getPixel(1, 1)).thenReturn(AsciiValue('e'))
    when(ascii2x3Image.getPixel(1, 2)).thenReturn(AsciiValue('d'))

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
