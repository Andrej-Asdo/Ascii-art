package Filter

import Image.{AsciiImage, GreyScaleImage}

/**
 * A generic filter
 */
trait Filter {
  /**
   * Filter the greyscale image and return the filtered one
   * @param greyScaleImage the image to be filtered
   * @return the filtered image
   */
  def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage
}
