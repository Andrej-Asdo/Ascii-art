package UI.parsers.loadParsers
import Loader.{GeneratorLoader, JPEGFileLoader, JPGFileLoader, Loader, PNGFileLoader}

import scala.util.Random

class ImageLoaderImplParser extends ImageLoaderParser {
  override def getLoader(command: String): Loader = {
    val importRegexPNG = "--image (.*(png))".r
    val importRegexJPG = "--image (.*(jpg))".r
    val importRegexJPEG = "--image (.*(jpeg))".r

    command match {
      // Random image will be used
      case "--image-random" =>
        new GeneratorLoader(new Random)
      // An existing image will be used
      case importRegexPNG(path, _) =>
        new PNGFileLoader(path)
      case importRegexJPG(path, _) =>
        new JPGFileLoader(path)
      case importRegexJPEG(path,_) =>
        new JPEGFileLoader(path)
      case _ => throw new IllegalArgumentException("Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!")
    }
  }
}
