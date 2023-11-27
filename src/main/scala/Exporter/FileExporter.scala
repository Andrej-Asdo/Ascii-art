package Exporter

import Image.AsciiImage

import java.io.{File, FileWriter, IOException}
import scala.util.Using

/**
 * An Exporter that exports to file
 * @param destination - the file to export to
 */
class FileExporter(destination: File) extends Exporter {
  private val fileWriter = try {
    new FileWriter(destination)
  }
  catch {
    case _: IOException =>
      throw new IOException("[File Exporter] Cannot create or open the file to output!")
  }

  override def `export`(asciiConvert: AsciiImage): Unit = {
    Using.resource(fileWriter) { fileWriter =>
      for (row <- 0 until asciiConvert.getHeight) {
        for (col <- 0 until asciiConvert.getWidth) {
          fileWriter.write(asciiConvert.getPixel(row, col).character)
        }
        fileWriter.write("\n")
      }
      fileWriter.close()
    }
  }
}
