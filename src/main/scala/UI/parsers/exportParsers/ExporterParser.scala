package UI.parsers.exportParsers

import Exporter.Exporter
import UI.parsers.Parser

trait ExporterParser extends Parser {
  /**
   * Get all types of exporters that user wishes to use.
   *
   * @param exportArguments - a string representation of exporters
   * @return all exporters that will be used
   * @throws IllegalArgumentException - if export way is illegal
   */
  def getExporter(exportArguments: Seq[String]): Exporter
}
