package Converter

/**
 * A general converter used to convert images in between various formats
 */
trait Converter[T,R] {
  /**
   * Converts GreyScale Image to Ascii Image
   * @param image a greyscale image
   * @return an ascii image
   */
  def convert(image: T): R
}
