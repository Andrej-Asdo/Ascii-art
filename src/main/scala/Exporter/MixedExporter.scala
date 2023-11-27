package Exporter

import Image.AsciiImage

/**
 * An Exporter that consist of a set of exporters
 * @param exporters - the exporters to be used
 */
class MixedExporter(exporters: Seq[Exporter]) extends Exporter {
  override def `export`(asciiConvert: AsciiImage): Unit = {
    exporters.foreach(exporter => exporter.`export`(asciiConvert))
  }
}
