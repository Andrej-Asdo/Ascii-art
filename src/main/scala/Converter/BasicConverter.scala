package Converter
import Converter.TransformationTable.TransformationTable
import Image.{AsciiImage, GreyScaleImage, Image}
import _root_.Image.Pixel.{GreyScaleValue, RGBValue, AsciiValue}

/**
 * A basic converter that uses a transformation table to transform images
 * @param transformTable a transform table according to which the transformation is done
 */
class BasicConverter(transformTable: TransformationTable) extends Converter{
  override def convertToAscii(image: GreyScaleImage): AsciiImage = {
    val converted = new AsciiImage(image.getHeight,image.getWidth)
    for(row <- 0 until image.getHeight) {
      for(col <- 0 until image.getWidth) {
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

  override def convertToGreyScale(image: Image[RGBValue]) : GreyScaleImage = {
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
   * @param pixel a RGB pixel
   * @return a GreyScale pixel
   */
  private def greyscaleValue(pixel: RGBValue): GreyScaleValue = (GreyScaleValue(((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt))
}
