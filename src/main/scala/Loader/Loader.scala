package Loader

import Image.RGBImage

/**
 * A trait that represents all image loaders
 */
trait Loader {
  /**
   * Loads the image and returns it
   * @return the loaded RGB image
   */
  def loadImage(): RGBImage
}
