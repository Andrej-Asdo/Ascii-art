package Converter.TransformationTable.LinearTable

import Converter.TransformationTable.TransformationTable

/**
 * A type of transformation table that gets characters linearly
 * @param table a table that is used
 */
class LinearTable(table: String) extends TransformationTable {
  def getCharacter(index: Int): Char = (table.charAt(((table.length) * index / 256).intValue()))
}
