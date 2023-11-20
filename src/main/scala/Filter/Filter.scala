package Filter

import Image.{AsciiImage, GreyScaleImage}

trait Filter {
  def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage
}
