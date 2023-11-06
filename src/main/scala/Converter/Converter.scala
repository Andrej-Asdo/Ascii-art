package Converter

import AsciiConvert.AsciiConvert
import Image.Image

trait Converter {
  def convertToAscii(image: Image): AsciiConvert
}
