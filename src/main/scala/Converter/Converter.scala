package Converter

import Image.{AsciiImage, GreyScaleImage, Image}
import _root_.Image.Pixel.RGBValue

/**
 * A general converter used to convert images in between various formats
 */
trait Converter {
  /**
   * Converts GreyScale Image to Ascii Image
   * @param image a greyscale image
   * @return an ascii image
   */
  def convertToAscii(image: GreyScaleImage): AsciiImage

  /**
   * Converts RGB Image to GreyScale Image
   * @param image a RGB Image
   * @return a greyscale image
   */
  def convertToGreyScale(image: Image[RGBValue]) : GreyScaleImage
}
