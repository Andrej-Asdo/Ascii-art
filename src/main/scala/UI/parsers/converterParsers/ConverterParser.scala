package UI.parsers.converterParsers

import Converter.Converter
import UI.parsers.Parser

trait ConverterParser[T,R] extends Parser {
  /**
   * Gets the converter that user wishes to use for converting his/hers image
   *
   * @param command - an argument for usage of a given table or converter
   * @return a converter to convert an image
   */
  def getConverter(command: String): Converter[T,R]
}
