package Image
import Image.Pixel.Pixel

import scala.util.Random
class GeneratedImage extends Image{
  private val height = Random.between(200, 900)
  private val width = Random.between(200, 900)
  private val pixels = Array.ofDim[Pixel](height, width)

  for (row <- 0 until height; col <- 0 until width) {
    pixels(row)(col) = Pixel(Random.between(0,255),Random.between(0,255),Random.between(0,255))
  }
  override def getHeight: Int = height

  override def getWidth: Int = width

  override def getPixel(row: Int, col: Int): Pixel = pixels(row)(col)
}
