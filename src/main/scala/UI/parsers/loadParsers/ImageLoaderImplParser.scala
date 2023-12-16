package UI.parsers.loadParsers
import Image.RGBImage
import Loader.{FileLoader, GeneratorLoader, Loader}

import scala.util.Random

class ImageLoaderImplParser extends ImageLoaderParser {
  override def getLoader(command: String): Loader = {
    val importRegex = "--image (.*(png|jpg|jpeg))".r
    command match {
      // Random image will be used
      case "--image-random" =>
        new GeneratorLoader(new Random)
      // An existing image will be used
      case importRegex(path, _) =>
        new FileLoader(path)
      case _ => throw new IllegalArgumentException("Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!")
    }
  }
}
