package Filter

import Image.Pixel.GreyScaleValue
import Image.{AsciiImage, GreyScaleImage}

/**
 * Rotates the image by a multiple of 90 degrees
 * @param degrees - the number of degrees it has to be turned
 */
class RotateFilter(degrees: Int) extends GreyScaleFilter {
  // Normalize degrees
  private val normalizedDegrees = degrees % 360
  override def filterImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    normalizedDegrees match {
      case -270 => rotateMinus90(rotateMinus90(rotateMinus90(greyScaleImage)))
      case -180 => rotateMinus90(rotateMinus90(greyScaleImage))
      case -90 => rotateMinus90(greyScaleImage)
      case 0 => greyScaleImage
      case 90 => rotate90(greyScaleImage)
      case 180 => rotate90(rotate90(greyScaleImage))
      case 270 => rotate90(rotate90(rotate90(greyScaleImage)))
      case _ => throw new IllegalArgumentException("[Rotate Filter] The degrees are not a multiple of 90!")
    }
  }

  /**
   * Rotate image by 90 degrees clockwise
   * @param greyScaleImage image to be rotated
   * @return rotated image
   */
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

  /**
   * Rotate image by 90 degrees counterclockwise
   * @param greyScaleImage the image to be rotated
   * @return rotated image
   */
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