package Loader
import Image.{GeneratedImage, RGBImage}
import _root_.Image.Pixel.RGBValue

import scala.util.Random

/**
 * A loader of a random image. Creates random image every time a loadImage method is called.
 */
class GeneratorLoader(private val random: Random) extends Loader {
  override def loadImage(): RGBImage = {

    // Random height
    val height = random.between(200, 900)
    // Random width
    val width = random.between(200, 900)
    val pixels = Array.ofDim[RGBValue](height, width)

    // Generate random pixels
    for (row <- 0 until height; col <- 0 until width) {
      pixels(row)(col) = RGBValue(random.between(0, 255), random.between(0, 255), random.between(0, 255))
    }

    new GeneratedImage(height, width, pixels)
  }
}
