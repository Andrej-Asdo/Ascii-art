package Filter

import Image.Pixel.GreyScaleValue
import Image.GreyScaleImage

/**
 * A Filter that inverts the values of greyscale pixels of the image
 */
class InvertFilter extends GreyScaleFilter {
  override def filterImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    for(row <- 0 until greyScaleImage.getHeight; col <- 0 until greyScaleImage.getWidth) {
      val formerValue = greyScaleImage.getPixel(row, col)
      // Invert the pixel
      val invertedValue = GreyScaleValue(255 - formerValue.greyScaleValue)
      greyScaleImage.setPixel(invertedValue,row, col)
    }
    greyScaleImage
  }
}
