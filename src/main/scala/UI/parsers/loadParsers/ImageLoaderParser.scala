package UI.parsers.loadParsers

import Image.RGBImage

trait ImageLoaderParser{
  /**
   * Gets image from the given arguments (either generated or path)
   *
   * @param command - an argument, that of wished image
   * @return a chosen image type
   * @throws IllegalArgumentException - if invalid argument or extension is provided
   */
  def loadImage(command: String): RGBImage
}
