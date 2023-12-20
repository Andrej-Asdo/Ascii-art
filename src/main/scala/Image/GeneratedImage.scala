package Image
import Image.Pixel.RGBValue

import scala.util.Random

/**
 * A generated image, the image will have random height, width and all its pixels
 * It's a type of RGB Image
 */
class GeneratedImage(private val height: Int, private val width: Int, private val inPixels: Array[Array[RGBValue]]) extends RGBImage {
  private val pixels = inPixels.map(_.clone())
  override def getHeight: Int = height

  override def getWidth: Int = width

  override def getPixel(row: Int, col: Int): RGBValue = {
    if (row > height || col > width)
      throw new IndexOutOfBoundsException("Out of bounds! The height or width of the picture is smaller than requested!")
    pixels(row)(col)
  }
}
