package Exporter

import Image.AsciiImage

object ConsoleExporter extends Exporter {
  override def `export`(asciiConvert: AsciiImage): Unit = {
    for(row <- 0 until asciiConvert.getHeight) {
      for(col <- 0 until asciiConvert.getWidth) {
        print(asciiConvert.getPixel(row, col).character)
      }
      println()
    }
  }
}
