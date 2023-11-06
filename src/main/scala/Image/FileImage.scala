package Image

import Image.Pixel.Pixel

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class FileImage(imageFile: File) extends ExistingImage {
  private val image: BufferedImage = ImageIO.read(imageFile)

  override def getHeight: Int = image.getHeight

  override def getWidth: Int = image.getWidth

  override def getPixel(row: Int, col: Int): Pixel = {
    val pixel = image.getRGB(col, row)
    val alpha: Int = (pixel >> 24) & 255
    val red: Int = (pixel >> 16) & 255
    val green: Int = (pixel >> 8) & 255
    val blue: Int = pixel & 255
    Pixel(red, green, blue)
  }
}
