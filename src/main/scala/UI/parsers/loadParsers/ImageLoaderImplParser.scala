package UI.parsers.loadParsers
import Image.RGBImage
import Loader.{FileLoader, GeneratorLoader}

import scala.util.Random

class ImageLoaderImplParser extends ImageLoaderParser {
  override def loadImage(command: String): RGBImage = {
    val importRegex = "--image (.*(png|jpg|jpeg))".r
    command match {
      // Random image will be used
      case "--image-random" =>
        new GeneratorLoader(new Random).loadImage()
      // An existing image will be used
      case importRegex(path, _) =>
        new FileLoader(path).loadImage()
      case _ => throw new IllegalArgumentException("Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!")
    }
  }
}
