package Image

import Image.Pixel.GreyScaleValue

class GreyScaleImage private (private val height: Int, private val width: Int, values: Array[Array[GreyScaleValue]]) extends Image[GreyScaleValue]{
  private val greyScaleValues = values

  def getPixel(row: Int, col: Int): GreyScaleValue = greyScaleValues(row)(col)

  def setPixel(greyScaleValue: GreyScaleValue, row: Int, col: Int): GreyScaleImage = {
    val cpyValues = greyScaleValues.clone()
    cpyValues(row)(col) = greyScaleValue
    new GreyScaleImage(height, width, cpyValues)
  }

  def getWidth: Int = width

  def getHeight: Int = height

  def this(height: Int, width: Int) = {
    this(height, width, Array.ofDim[GreyScaleValue](height, width))
  }
}
