package Converter.TransformationTable.LinearTable

import Converter.TransformationTable.TransformationTable

class LinearTable(table: String) extends TransformationTable {
  def getCharacter(index: Int): Char = (table.charAt(((table.length) * index / 256).intValue()))
}
