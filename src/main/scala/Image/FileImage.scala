package Image

import Image.Pixel.RGBValue

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.util.Using

/**
 * An existing image from file.
 * A type of an RGB Image
 * @param imageFile a file that contains the image
 */
class FileImage(imageFile: File) extends ExistingImage[RGBValue] {
  private val image: BufferedImage = ImageIO.read(imageFile)

  override def getHeight: Int = image.getHeight

  override def getWidth: Int = image.getWidth

  override def getPixel(row: Int, col: Int): RGBValue = {
    if(row > getHeight || col > getWidth)
      throw new IndexOutOfBoundsException("Out of bounds! The height or width of the picture is smaller than requested!")
    val pixel = image.getRGB(col, row)
    val alpha: Int = (pixel >> 24) & 255
    val red: Int = (pixel >> 16) & 255
    val green: Int = (pixel >> 8) & 255
    val blue: Int = pixel & 255
    RGBValue(red, green, blue)
  }
}
