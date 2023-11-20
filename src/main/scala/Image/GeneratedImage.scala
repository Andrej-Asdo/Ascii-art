package Image
import Image.Pixel.RGBValue

import scala.util.Random
class GeneratedImage extends Image[RGBValue]{
  private val random = new Random
  private val height = random.between(200, 900)
  private val width = random.between(200, 900)
  private val pixels = Array.ofDim[RGBValue](height, width)

  for (row <- 0 until height; col <- 0 until width) {
    pixels(row)(col) = RGBValue(random.between(0,255),random.between(0,255),random.between(0,255))
  }
  override def getHeight: Int = height

  override def getWidth: Int = width

  override def getPixel(row: Int, col: Int): RGBValue = pixels(row)(col)
}
