package UI.parsers.converterParsers

import Converter.AsciiConverter
import org.scalatest.FunSuite

class AsciiConverterParserTest extends FunSuite{
  test("Get Ascii Converter with Simple Burkes Table") {
    val command = "--table SimpleBurkes"
    val converterParser = new AsciiConverterParser
    val converter = converterParser.getConverter(command)
    assert(converter.isInstanceOf[AsciiConverter])
  }

  test("Get Ascii Converter with Paul Burkes Table") {
    val command = "--table PaulBurkes"
    val converterParser = new AsciiConverterParser
    val converter = converterParser.getConverter(command)
    assert(converter.isInstanceOf[AsciiConverter])
  }

  test("Get Ascii Converter with Nonlinear Table") {
    val command = "--table Nonlinear"
    val converterParser = new AsciiConverterParser
    val converter = converterParser.getConverter(command)
    assert(converter.isInstanceOf[AsciiConverter])
  }

  test("Get Ascii Converter with Custom Table") {
    val command = "--custom-table abcdefghijkl"
    val converterParser = new AsciiConverterParser
    val converter = converterParser.getConverter(command)
    assert(converter.isInstanceOf[AsciiConverter])
  }

  test("Get Ascii Converter with Wrong Table") {
    val command = "--table Nonexistent"
    val converterParser = new AsciiConverterParser
    val converter = converterParser.getConverter(command)
    assert(converter.isInstanceOf[AsciiConverter])
  }

}
