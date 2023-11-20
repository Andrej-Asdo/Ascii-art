package Filter

import Image.{AsciiImage, GreyScaleImage}

class ScaleFilter(scale: Double) extends Filter {
  override def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    scale match {
      case 0.25 => scaleToQuarter(greyScaleImage)
      case 1 => greyScaleImage
      case 4 => scaleFourTimes(greyScaleImage)
      case _ => greyScaleImage
    }
  }

  private def scaleToQuarter(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    val rescaled = new GreyScaleImage(greyScaleImage.getHeight / 2, greyScaleImage.getWidth / 2)
    for (row <- 0 until rescaled.getHeight by 2) {
      for (col <- 0 until rescaled.getWidth by 2) {
        // Get ascii char from old Ascii
        val character = greyScaleImage.getPixel(row, col)
        // Set it
        rescaled.setPixel(character, row, col)
      }
    }
    rescaled
  }

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
