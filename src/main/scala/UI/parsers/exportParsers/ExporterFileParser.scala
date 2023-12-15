package UI.parsers.exportParsers

import Exporter.{ConsoleExporter, Exporter, FileExporter, MixedExporter}

import java.io.File

class ExporterFileParser extends ExporterParser {
  override def getExporter(exportArguments: Seq[String]): Exporter = {
    var exporters = List[Exporter]()
    val exportRegex = "--output-file (.*)".r
    for (argument <- exportArguments) {
      argument match {

        //Regex ok, we have the path
        case exportRegex(path) =>
          exporters = exporters.appended(new FileExporter(new File(path)))

        // Only output to console
        case "--output-console" =>
          exporters = exporters.appended(ConsoleExporter)

        case _ =>
          throw new IllegalArgumentException("Invalid type of output! Use --output-console and/or --output-file path!")
      }
    }
    new MixedExporter(exporters)
  }

}
