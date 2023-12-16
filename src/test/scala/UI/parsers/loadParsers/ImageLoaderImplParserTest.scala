package UI.parsers.loadParsers

import Image.RGBImage
import Loader.{FileLoader, GeneratorLoader}
import org.scalatest.FunSuite

class ImageLoaderImplParserTest extends FunSuite {
  test("Get Generator Loader") {
    val command = "--image-random"
    val loaderImplParser = new ImageLoaderImplParser
    val loader = loaderImplParser.getLoader(command)
    assert(loader.isInstanceOf[GeneratorLoader])
  }

  test("Get File Loader") {
    val command = "--image ./images/jpg/prague.jpg"
    val loaderImplParser = new ImageLoaderImplParser
    val loadedImage = loaderImplParser.getLoader(command)
    assert(loadedImage.isInstanceOf[FileLoader])
  }
}
