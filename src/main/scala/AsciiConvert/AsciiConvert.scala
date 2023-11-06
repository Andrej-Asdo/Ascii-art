package AsciiConvert

class AsciiConvert(private val height: Int, private val width: Int) {
  private val characters = Array.ofDim[Char](height, width)

  def getCharacter(row: Int, col: Int): Char = characters(row)(col)
  def setCharacter(character: Char, row: Int, col: Int): Unit = characters(row)(col) = character

  def getWidth: Int = width
  def getHeight: Int = height
}
