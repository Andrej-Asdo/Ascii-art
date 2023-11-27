package Image

import Image.Pixel.{Pixel, RGBValue}

/**
 * A structure that represents an image in any state
 * @tparam Pixel a type of the image that will be stored
 */
trait Image[Pixel] {
  def getHeight: Int
  def getWidth: Int
  def getPixel(row: Int, col: Int): Pixel
}
