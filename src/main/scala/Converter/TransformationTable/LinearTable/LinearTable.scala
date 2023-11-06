package Converter.TransformationTable.LinearTable

import Converter.TransformationTable.TransformationTable

class LinearTable(table: String) extends TransformationTable {
  def getCharacter(index: Int): Char = table.charAt(index % table.length)
}
