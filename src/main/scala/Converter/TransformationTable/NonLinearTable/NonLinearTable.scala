package Converter.TransformationTable.NonLinearTable

import Converter.TransformationTable.TransformationTable

object NonLinearTable extends TransformationTable {
  override def getCharacter(index: Int): Char = {
    index match {
      case x if x < 10 => 'X'
      case x if x < 50 => 'A'
      case x if x < 100 => 'B'
      case x if x < 132 => 'C'
      case x if x < 167 => 'D'
      case x if x < 168 => 'E'
      case x if x < 169 => 'a'
      case x if x < 199 => 'x'
      case x if x < 201 => 'z'
      case x if x < 247 => 'k'
      case x if x < 255 => 'u'
      case _ => 'I'
    }
  }
}
