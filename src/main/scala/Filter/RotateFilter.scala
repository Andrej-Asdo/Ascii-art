package Filter

import Image.Pixel.GreyScaleValue
import Image.{AsciiImage, GreyScaleImage}

class RotateFilter(degrees: Int) extends Filter {
  private val normalizedDegrees = degrees % 360
  override def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    normalizedDegrees match {
      case -270 => rotateMinus90(rotateMinus90(rotateMinus90(greyScaleImage)))
      case -180 => rotateMinus90(rotateMinus90(greyScaleImage))
      case -90 => rotateMinus90(greyScaleImage)
      case 0 => greyScaleImage
      case 90 => rotate90(greyScaleImage)
      case 180 => rotate90(rotate90(greyScaleImage))
      case 270 => rotate90(rotate90(rotate90(greyScaleImage)))
    }
  }

  private def rotate90(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    val rows = greyScaleImage.getHeight
    val cols = greyScaleImage.getWidth
    val result = new GreyScaleImage(cols, rows)

    for (i <- 0 until rows; j <- 0 until cols) {
      val pixel = greyScaleImage.getPixel(i,j)
      result.setPixel(pixel, j, (rows - i - 1))
    }

    result
  }

  private def rotateMinus90(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    val rows = greyScaleImage.getHeight
    val cols = greyScaleImage.getWidth
    val result = new GreyScaleImage(cols, rows)

    for (i <- 0 until rows; j <- 0 until cols) {
      val pixel = greyScaleImage.getPixel(i, (cols - j - 1))
      result.setPixel(pixel, j, i)
    }

    result
  }
}