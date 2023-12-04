package Image
import Image.Pixel.RGBValue

import scala.util.Random

/**
 * A generated image, the image will have random height, width and all its pixels
 * It's a type of RGB Image
 */
class GeneratedImage(private val height: Int, private val width: Int, private val pixels: Array[Array[RGBValue]]) extends RGBImage {
  override def getHeight: Int = height

  override def getWidth: Int = width

  override def getPixel(row: Int, col: Int): RGBValue = pixels(row)(col)
}
