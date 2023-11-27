package Converter.TransformationTable

/**
 * A general transformation table
 */
trait TransformationTable {
  /**
   * Returns a character that corresponds to the given index
   * @param index index of the character
   * @return the character
   */
  def getCharacter(index: Int): Char
}
