package Image
import Image.Pixel.RGBValue

import scala.util.Random

/**
 * A generated image, the image will have random height, width and all its pixels
 * It's a type of RGB Image
 */
class GeneratedImage extends Image[RGBValue]{
  private val random = new Random
  // Random height
  private val height = random.between(200, 900)
  // Random width
  private val width = random.between(200, 900)
  private val pixels = Array.ofDim[RGBValue](height, width)

  // Generate random pixels
  for (row <- 0 until height; col <- 0 until width) {
    pixels(row)(col) = RGBValue(random.between(0,255),random.between(0,255),random.between(0,255))
  }
  override def getHeight: Int = height

  override def getWidth: Int = width

  override def getPixel(row: Int, col: Int): RGBValue = pixels(row)(col)
}
