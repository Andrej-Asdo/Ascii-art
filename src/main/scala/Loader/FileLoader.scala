package Loader
import Image.{FileImage, RGBImage}

import java.awt.image.BufferedImage
import java.io.{File, IOException}
import javax.imageio.ImageIO
import scala.util.matching.Regex

/**
 * Loader of images from file
 * @param path - a path where the file is located
 * @param importRegex - a regex according to which an importing follows
 */
abstract class FileLoader(path: String, importRegex: Regex) extends Loader {
  // Regex of supported formats
  //private val importRegex = "(.*(png|jpg|jpeg))".r

  // Check for a supported format
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
