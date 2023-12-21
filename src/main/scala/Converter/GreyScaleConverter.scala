package Converter

import Image.{GreyScaleImage, RGBImage}
import _root_.Image.Pixel.{GreyScaleValue, RGBValue}

/**
 * Converts RGB Image to GreyScale Image
 */
class GreyScaleConverter extends Converter[RGBImage,GreyScaleImage]{
  override def convert(image: RGBImage): GreyScaleImage = {
    val converted = new GreyScaleImage(image.getHeight, image.getWidth)
    for (row <- 0 until image.getHeight) {
      for (col <- 0 until image.getWidth) {
        // Get pixel from image
        val pixel = image.getPixel(row, col)
        // Get greyscale value of the pixel
        val greyscale = greyscaleValue(pixel)
        // Set it
        converted.setPixel(greyscale, row, col)
      }
    }
    converted
  }

  /**
   * Converts a RGB pixel to a GreyScale pixel
   *
   * @param pixel a RGB pixel
   * @return a GreyScale pixel
   */
  private def greyscaleValue(pixel: RGBValue): GreyScaleValue = (GreyScaleValue(((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt))
}
