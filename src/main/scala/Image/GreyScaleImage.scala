package Image

import Image.Pixel.GreyScaleValue

/**
 * A greyscale image
 * @param height the height of an image
 * @param width the width of an image
 */
class GreyScaleImage (private val height: Int, private val width: Int) extends Image[GreyScaleValue]{
  private val greyScaleValues = Array.ofDim[GreyScaleValue](height, width)

  def getPixel(row: Int, col: Int): GreyScaleValue = {
    if(row > height || col > width)
      throw new IndexOutOfBoundsException("Out of bounds! The height or width of the picture is smaller than requested!")
    greyScaleValues(row)(col)
  }

  def setPixel(greyScaleValue: GreyScaleValue, row: Int, col: Int): GreyScaleImage = {
    if (row > height || col > width)
      throw new IndexOutOfBoundsException("Out of bounds! The height or width of the picture is smaller than requested!")
    greyScaleValues(row)(col) = greyScaleValue
    this
  }

  def getWidth: Int = width

  def getHeight: Int = height
}
