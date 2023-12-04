package Converter.TransformationTable.NonLinearTableTest

import Converter.TransformationTable.NonLinearTable.NonLinearTable
import org.scalatest.FunSuite

class NonLinearTableTest extends FunSuite {
  test("Test Nonlinear Table") {
    val table = NonLinearTable
    assert(table.getCharacter(5) == 'X')
    assert(table.getCharacter(10) == 'A')
    assert(table.getCharacter(0) == 'X')
    assert(table.getCharacter(32) == 'A')
    assert(table.getCharacter(44) == 'A')
    assert(table.getCharacter(58) == 'B')
    assert(table.getCharacter(78) == 'B')
    assert(table.getCharacter(93) == 'B')
    assert(table.getCharacter(99) == 'B')
    assert(table.getCharacter(100) == 'C')
    assert(table.getCharacter(150) == 'D')
    assert(table.getCharacter(167) == 'E')
    assert(table.getCharacter(168) == 'a')
    assert(table.getCharacter(169) == 'x')
    assert(table.getCharacter(185) == 'x')
    assert(table.getCharacter(199) == 'z')
    assert(table.getCharacter(200) == 'z')
    assert(table.getCharacter(230) == 'k')
    assert(table.getCharacter(254) == 'u')
    assert(table.getCharacter(255) == 'I')
    assert(table.getCharacter(300) == 'I')
    assert(table.getCharacter(351531) == 'I')
  }
}
