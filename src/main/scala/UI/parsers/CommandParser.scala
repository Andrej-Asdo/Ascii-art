package UI.parsers

import UI.parsers.converterParsers.AsciiConverterParser
import UI.parsers.exportParsers.ExporterParser
import UI.parsers.filterParsers.FilterParser
import UI.parsers.loadParsers.ImageLoaderParser

class CommandParser(val filterParser: FilterParser, val converterAsciiParser: AsciiConverterParser, val exporterParser: ExporterParser, val loaderParser: ImageLoaderParser) {

}
