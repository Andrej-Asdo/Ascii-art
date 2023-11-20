package Filter

import Image.Pixel.GreyScaleValue
import Image.{AsciiImage, GreyScaleImage}

class InvertFilter extends Filter {
  override def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    for(row <- 0 until greyScaleImage.getHeight; col <- 0 until greyScaleImage.getWidth) {
      val formerValue = greyScaleImage.getPixel(row, col)
      val invertedValue = GreyScaleValue(255 - formerValue.greyScaleValue)
      greyScaleImage.setPixel(invertedValue,row, col)
    }
    greyScaleImage
  }
}
