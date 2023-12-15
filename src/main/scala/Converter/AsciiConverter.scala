package Converter

import Converter.TransformationTable.TransformationTable
import Image.Pixel.{AsciiValue, RGBValue}
import Image.{AsciiImage, GreyScaleImage, Image}

/**
 * Converts GreyScale Image to Ascii Image
 * @param transformTable a table according to which the transformation is executed
 */
class AsciiConverter(transformTable: TransformationTable) extends Converter[GreyScaleImage,AsciiImage]{
  override def convert(image: GreyScaleImage): AsciiImage = {
    val converted = new AsciiImage(image.getHeight, image.getWidth)
    for (row <- 0 until image.getHeight) {
      for (col <- 0 until image.getWidth) {
        // Get greyscale from image
        val greyscale = image.getPixel(row, col)
        // Transform the pixel to a character using provided table
        val character = transformTable.getCharacter(greyscale.greyScaleValue)
        // Set it
        converted.setPixel(AsciiValue(character), row, col)
      }
    }
    converted
  }
}
