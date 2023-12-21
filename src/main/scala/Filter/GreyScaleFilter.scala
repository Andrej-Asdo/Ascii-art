package Filter

import Image.GreyScaleImage

/**
 * A generic filter of greyscale images
 */
trait GreyScaleFilter extends Filter[GreyScaleImage]{
  /**
   * Filter the greyscale image and return the filtered one
   * @param greyScaleImage the image to be filtered
   * @return the filtered image
   */
  override def filterImage(greyScaleImage: GreyScaleImage): GreyScaleImage
}
