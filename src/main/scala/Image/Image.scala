package Image

import Image.Pixel.Pixel

trait Image {
  def getHeight: Int
  def getWidth: Int
  def getPixel(row: Int, col: Int): Pixel
}
