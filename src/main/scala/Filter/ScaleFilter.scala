package Filter

import Image.{AsciiImage, GreyScaleImage}

/**
 * A Filter that scales the image 0.25, 1 or 4 times
 * @param scale the scale
 */
class ScaleFilter(scale: Double) extends Filter {
  override def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    scale match {
      case 0.25 => scaleToQuarter(greyScaleImage)
      case 1 => greyScaleImage
      case 4 => scaleFourTimes(greyScaleImage)
      case _ => throw new IllegalArgumentException("[Scale Filter] Invalid scale! Use 0.25, 1 or 4!")
    }
  }

  /**
   * Scale the image to 0.25 times
   * @param greyScaleImage - the image to be scaled
   * @return the scaled image
   */
  private def scaleToQuarter(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    val rescaled = new GreyScaleImage(greyScaleImage.getHeight / 2, greyScaleImage.getWidth / 2)
    for (row <- 0 until greyScaleImage.getHeight by 2) {
      for (col <- 0 until greyScaleImage.getWidth by 2) {
        // Get ascii char from old Ascii
        val character = greyScaleImage.getPixel(row, col)
        // Set it
        rescaled.setPixel(character, row / 2 , col / 2)
      }
    }
    rescaled
  }

  /**
   * Scale the image 4 times
   * @param greyScaleImage - the image to be scaled
   * @return the scaled image
   */
  private def scaleFourTimes(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    val rescaled = new GreyScaleImage(greyScaleImage.getHeight * 2, greyScaleImage.getWidth * 2)
    for (row <- 0 until greyScaleImage.getHeight) {
      for (col <- 0 until greyScaleImage.getWidth) {
        // Get ascii char from old Ascii
        val character = greyScaleImage.getPixel(row, col)
        // Set all 4 characters
        rescaled.setPixel(character, 2*row, 2*col)
        rescaled.setPixel(character, 2*row, 2*col + 1)
        rescaled.setPixel(character, 2*row + 1, 2*col)
        rescaled.setPixel(character, 2*row + 1, 2*col + 1)
      }
    }
    rescaled
  }
}
