package Image

trait Image {
  def getHeight: Int
  def getWidth: Int
  def getPixel(row: Int, col: Int): Int
}
