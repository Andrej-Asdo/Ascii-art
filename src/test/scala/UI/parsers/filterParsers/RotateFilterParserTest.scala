package UI.parsers.filterParsers

import Filter.RotateFilter
import org.scalatest.FunSuite

class RotateFilterParserTest extends FunSuite{
  test("Get Rotate Filter +90") {
    val command = "--rotate +90"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter 90") {
    val command = "--rotate 90"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter -90") {
    val command = "--rotate -90"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter +45") {
    val command = "--rotate +45"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter +9250") {
    val command = "--rotate +9250"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter -890") {
    val command = "--rotate -890"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter 990") {
    val command = "--rotate 990"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[RotateFilter])
  }

  test("Get Rotate Filter ABC") {
    val command = "--rotate ABC"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }

  test("Get Rotate Filter +ABC") {
    val command = "--rotate +ABC"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }

  test("Get Wrong Name") {
    val command = "--rotated +90"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }

  test("Get Another Filter") {
    val command = "--invert"
    val rotateFilterParser = new RotateFilterParser
    val filter = rotateFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }
}
