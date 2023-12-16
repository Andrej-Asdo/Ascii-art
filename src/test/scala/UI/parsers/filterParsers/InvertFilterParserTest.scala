package UI.parsers.filterParsers

import Filter.InvertFilter
import net.bytebuddy.dynamic.scaffold.TypeInitializer.None
import org.scalatest.FunSuite

class InvertFilterParserTest extends FunSuite {
  test("Get Invert Filter") {
    val command = "--invert"
    val invertFilterParser = new InvertFilterParser
    val filter = invertFilterParser.getFilterFromName(command)
    assert(filter.isDefined)
    assert(filter.get.isInstanceOf[InvertFilter])
  }

  test("Get Invert Filter With Invalid Name") {
    val command = "--scale"
    val invertFilterParser = new InvertFilterParser
    val filter = invertFilterParser.getFilterFromName(command)
    assert(filter.isEmpty)
  }
}
