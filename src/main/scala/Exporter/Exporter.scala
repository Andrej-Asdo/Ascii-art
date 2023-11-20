package Exporter

import Image.AsciiImage

trait Exporter {
  def export(asciiConvert: AsciiImage): Unit
}
