package UI.parsers.exportParsers

import Exporter.MixedExporter
import org.scalatest.FunSuite

class ExporterImplParserTest extends FunSuite {
  test("Get Exporter to Console") {
    val commands = List[String] {
      "--output-console"
    }
    val exporterImplParser = new ExporterImplParser
    val exporter = exporterImplParser.getExporter(commands)
    assert(exporter.isInstanceOf[MixedExporter])
  }

  test("Get Exporter to File") {
    val commands = List[String] {
      "--output-file file.txt"
    }
    val exporterImplParser = new ExporterImplParser
    val exporter = exporterImplParser.getExporter(commands)
    assert(exporter.isInstanceOf[MixedExporter])
  }

  test("Get Both Exporters") {
    val commands = List[String] (
      "--output-file file.txt",
      "--output-console"
    )
    val exporterImplParser = new ExporterImplParser
    val exporter = exporterImplParser.getExporter(commands)
    assert(exporter.isInstanceOf[MixedExporter])
  }

  test("Get Invalid Exporter") {
    val commands = List[String](
      "--output-command",
    )
    val exporterImplParser = new ExporterImplParser
    assertThrows[IllegalArgumentException](exporterImplParser.getExporter(commands))
  }

  test("Get Invalid Exporter And Correct Exporter") {
    val commands = List[String](
      "--output-console",
      "--output-command",
    )
    val exporterImplParser = new ExporterImplParser
    assertThrows[IllegalArgumentException](exporterImplParser.getExporter(commands))
  }
}
