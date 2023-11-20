package Image

import Image.Pixel.{Pixel, RGBValue}

trait Image[Pixel] {
  def getHeight: Int
  def getWidth: Int
  def getPixel(row: Int, col: Int): Pixel
}
