package Exporter

import Image.AsciiImage

class MixedExporter(exporters: Seq[Exporter]) extends Exporter {
  override def `export`(asciiConvert: AsciiImage): Unit = {
    exporters.foreach(exporter => exporter.`export`(asciiConvert))
  }
}
