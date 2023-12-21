package UI.parsers.filterParsers

import Filter.ScaleFilter
import org.scalatest.FunSuite

class ScaleFilterParserTest extends FunSuite {
  test("Get Scale Filter 0.25") {
    val command = "--scale 0.25"
    val scaleFilterParser = new ScaleFilterParser
    val filter = scaleFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[ScaleFilter])
  }

  test("Get Scale Filter 1") {
    val command = "--scale 1"
    val scaleFilterParser = new ScaleFilterParser
    val filter = scaleFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[ScaleFilter])
  }

  test("Get Scale Filter 10") {
    val command = "--scale 10"
    val scaleFilterParser = new ScaleFilterParser
    val filter = scaleFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[ScaleFilter])
  }

  test("Get Scale Filter ABC") {
    val command = "--scale ABC"
    val scaleFilterParser = new ScaleFilterParser
    val filter = scaleFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }

  test("Wrong Filter") {
    val command = "--invert 0.25"
    val scaleFilterParser = new ScaleFilterParser
    val filter = scaleFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }

  test("Wrong Name") {
    val command = "--scaled 0.25"
    val scaleFilterParser = new ScaleFilterParser
    val filter = scaleFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }
}
