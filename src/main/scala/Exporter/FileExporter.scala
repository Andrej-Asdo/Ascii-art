package Exporter

import Image.AsciiImage
import java.io.{File, FileWriter}

class FileExporter(destination: File) extends Exporter {
  private val fileWriter = new FileWriter(destination)

  override def `export`(asciiConvert: AsciiImage): Unit = {
    for (row <- 0 until asciiConvert.getHeight) {
      for (col <- 0 until asciiConvert.getWidth) {
        fileWriter.write(asciiConvert.getPixel(row, col).character)
      }
      fileWriter.write("\n")
    }
    fileWriter.close()
  }
}
