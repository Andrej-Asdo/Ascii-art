package Image

import Image.Pixel.AsciiValue

class AsciiImage private (private val height: Int, private val width: Int, values: Array[Array[AsciiValue]]) extends Image[AsciiValue]{
  private val characters = Array.ofDim[AsciiValue](height, width)

  def getPixel(row: Int, col: Int): AsciiValue = characters(row)(col)
  def setPixel(character: AsciiValue, row: Int, col: Int): AsciiImage =  {
//    val cpyValues = characters.clone()
//    cpyValues(row)(col) = character
//    new AsciiImage(height, width, cpyValues)
    characters(row)(col) = character
    this
  }

  def getWidth: Int = width
  def getHeight: Int = height

  def this(height: Int, width: Int) = {
    this(height, width, Array.ofDim[AsciiValue](height, width))
  }
}
