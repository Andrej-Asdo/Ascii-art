package Converter.TransformationTable.LinearTable

import Converter.TransformationTable.TransformationTable

/**
 * A type of transformation table that gets characters linearly
 * @param table a table that is used
 */
class LinearTable(table: String) extends TransformationTable {
  def getCharacter(index: Int): Char = {
    val charIndex = ((table.length) * index / 256).intValue()
    if (charIndex >= table.length) {
      throw new IndexOutOfBoundsException("[Linear Table] Character was out of bounds for a given table")
    }
    (table.charAt(charIndex))
  }
}
