package Filter

/**
 * A generic filter
 */
trait Filter[T] {
  /**
   * Filter the greyscale image and return the filtered one
   *
   * @param image the image to be filtered
   * @return the filtered image
   */
  def filterImage(image: T): T
}
