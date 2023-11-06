package Converter
import AsciiConvert.AsciiConvert
import Converter.TransformationTable.TransformationTable
import Image.Image
import _root_.Image.Pixel.Pixel

class BasicConverter(transformTable: TransformationTable) extends Converter{
  override def convertToAscii(image: Image): AsciiConvert = {
    val converted = new AsciiConvert(image.getHeight,image.getWidth)
    for(row <- 0 until image.getHeight) {
      for(col <- 0 until image.getWidth) {
        // Get pixel from image
        val pixel = image.getPixel(row, col)
        // Get greyscale value of the pixel
        val greyscale = greyscaleValue(pixel)
        // Transform the pixel to a character using provided table
        val character = transformTable.getCharacter(greyscale)
        // Set it
        converted.setCharacter(character, row, col)
      }
    }
    converted
  }

  private def greyscaleValue(pixel: Pixel): Int = (((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt)
}
