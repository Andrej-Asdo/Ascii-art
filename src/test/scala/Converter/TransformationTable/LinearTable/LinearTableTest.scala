package Converter.TransformationTable.LinearTable

import org.scalatest.FunSuite

class LinearTableTest extends FunSuite {
  test("[Linear Table] Get characters from PaulBurkesTable") {
    val linearTable = PaulBurkesTable
    assert(linearTable.getCharacter(0) == '$')
    assert(linearTable.getCharacter(150) == '\\')
    assert(linearTable.getCharacter(184) == '?')
    assert(linearTable.getCharacter(167) == '1')
    assert(linearTable.getCharacter(75) == 'Z')
    assert(linearTable.getCharacter(255) == ' ')
    assertThrows[IndexOutOfBoundsException](linearTable.getCharacter(258))
    assertThrows[IndexOutOfBoundsException](linearTable.getCharacter(300))
  }

  test("[Linear Table] Get characters from own table") {
    val linearTable = new LinearTable("abcdefghijklmn")
    assert(linearTable.getCharacter(0) == 'a')
    assert(linearTable.getCharacter(150) == 'i')
    assert(linearTable.getCharacter(184) == 'k')
    assert(linearTable.getCharacter(167) == 'j')
    assert(linearTable.getCharacter(75) == 'e')
    assert(linearTable.getCharacter(255) == 'n')
    assertThrows[IndexOutOfBoundsException](linearTable.getCharacter(258))
    assertThrows[IndexOutOfBoundsException](linearTable.getCharacter(300))
  }
}
