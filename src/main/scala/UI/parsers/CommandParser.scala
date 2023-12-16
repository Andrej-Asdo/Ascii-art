package UI.parsers

import UI.parsers.converterParsers.AsciiConverterParser
import UI.parsers.exportParsers.ExporterParser
import UI.parsers.filterParsers.FilterParser
import UI.parsers.loadParsers.ImageLoaderParser

/**
 * A general command parser that holds all the parsers available
 * @param filterParser a parser to parse filter commands
 * @param converterAsciiParser a parser to parse converter commands
 * @param exporterParser a parser to parse exporter commands
 * @param loaderParser a parser to parse loader commands
 */
class CommandParser(val filterParser: FilterParser, val converterAsciiParser: AsciiConverterParser, val exporterParser: ExporterParser, val loaderParser: ImageLoaderParser) {

}
