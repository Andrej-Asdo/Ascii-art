package Loader
import Image.{AsciiImage, FileImage, Image, RGBImage}

import java.awt.image.BufferedImage
import java.io.{File, IOException}
import javax.imageio.ImageIO

class FileLoader(path: String) extends Loader {
  private val importRegex = "(.*(png|jpg|jpeg))".r
  if (path match {
    case importRegex(_,_) => true
    case _ => false
  }) {}
  else {
    throw new IllegalArgumentException("Invalid image extension! Use --image path.(png|jpg|jpeg)!")
  }
  private val file = new File(path)

  override def loadImage(): RGBImage = {
    val image: BufferedImage = try { ImageIO.read(file) } catch {case e: IOException => throw new IOException("[Input Image] Error loading the contents of image!")}
    new FileImage(image)
  }
}
