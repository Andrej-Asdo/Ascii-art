package UI.parsers.filterParsers

import Filter.MixedFilter
import org.scalatest.FunSuite

class FilterImplParserTest extends FunSuite {
  test("Get One Filter") {
    val commands = List[String](
      "--invert",
    )
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )
    val filterImplParser = new FilterImplParser(listFilterParsers)
    val filters = filterImplParser.getFilterFromNames(commands)
    assert(filters.isInstanceOf[MixedFilter])
  }

  test("Get More Filters") {
    val commands = List[String](
      "--invert",
      "--scale 0.25"
    )
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )
    val filterImplParser = new FilterImplParser(listFilterParsers)
    val filters = filterImplParser.getFilterFromNames(commands)
    assert(filters.isInstanceOf[MixedFilter])
  }

  test("Get The Same Filter") {
    val commands = List[String](
      "--invert",
      "--invert"
    )
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )
    val filterImplParser = new FilterImplParser(listFilterParsers)
    val filters = filterImplParser.getFilterFromNames(commands)
    assert(filters.isInstanceOf[MixedFilter])
  }

  test("Get No Filter") {
    val commands = List[String]()
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )
    val filterImplParser = new FilterImplParser(listFilterParsers)
    val filters = filterImplParser.getFilterFromNames(commands)
    assert(filters.isInstanceOf[MixedFilter])
  }

  test("Get One Filter Wrong") {
    val commands = List[String](
      "--invert",
      "--scaled 0.25"
    )
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )
    val filterImplParser = new FilterImplParser(listFilterParsers)
    assertThrows[IllegalArgumentException](filterImplParser.getFilterFromNames(commands))
  }

  test("Get Filter Completely Wrong") {
    val commands = List[String](
      "--upscaled",
    )
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )
    val filterImplParser = new FilterImplParser(listFilterParsers)
    assertThrows[IllegalArgumentException](filterImplParser.getFilterFromNames(commands))
  }
}
