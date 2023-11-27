package Exporter

import Image.AsciiImage

/**
 * A general exporter that exports an Ascii Image
 */
trait Exporter {
  def export(asciiConvert: AsciiImage): Unit
}
