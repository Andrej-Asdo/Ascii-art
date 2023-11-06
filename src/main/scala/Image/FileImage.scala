package Image

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class FileImage(imageFile: File) extends ExistingImage {
  private val image: BufferedImage = ImageIO.read(imageFile)

  override def getHeight: Int = image.getHeight

  override def getWidth: Int = image.getWidth

  override def getPixel(row: Int, col: Int): Int = (image.getRGB(col, row) >> 16) & 255

  /*
                val alpha: Int = (RGBA >> 24) & 255
                val red: Int = (RGBA >> 16) & 255
                val green: Int = (RGBA >> 8) & 255
                val blue: Int = RGBA & 255
   */
}
