package Converter

import Image.{AsciiImage, GreyScaleImage, Image}
import _root_.Image.Pixel.RGBValue

trait Converter {
  def convertToAscii(image: GreyScaleImage): AsciiImage
  def convertToGreyScale(image: Image[RGBValue]) : GreyScaleImage
}
