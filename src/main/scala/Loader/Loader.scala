package Loader

import Image.{AsciiImage, Image, RGBImage}

trait Loader {
  def loadImage(): RGBImage
}
