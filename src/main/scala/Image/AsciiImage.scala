package Image

import Image.Pixel.AsciiValue

/**
 * A type of an Ascii image
 * @param height the height of an image
 * @param width the width of an image
 */
class AsciiImage (private val height: Int, private val width: Int) extends Image[AsciiValue]{
  private val characters = Array.ofDim[AsciiValue](height, width)

  def getPixel(row: Int, col: Int): AsciiValue = {
    if (row > height || col > width)
      throw new IndexOutOfBoundsException("Out of bounds! The height or width of the picture is smaller than requested!")
    characters(row)(col)
  }
  def setPixel(character: AsciiValue, row: Int, col: Int): AsciiImage =  {
    if (row > height || col > width)
      throw new IndexOutOfBoundsException("Out of bounds! The height or width of the picture is smaller than requested!")
    characters(row)(col) = character
    this
  }

  def getWidth: Int = width
  def getHeight: Int = height
}
