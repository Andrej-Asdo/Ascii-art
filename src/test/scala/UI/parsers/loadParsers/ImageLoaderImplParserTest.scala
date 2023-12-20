package UI.parsers.loadParsers

import Loader.{GeneratorLoader, JPEGFileLoader, JPGFileLoader, PNGFileLoader}
import org.scalatest.FunSuite

class ImageLoaderImplParserTest extends FunSuite {
  test("Get Generator Loader") {
    val command = "--image-random"
    val loaderImplParser = new ImageLoaderImplParser
    val loader = loaderImplParser.getLoader(command)
    assert(loader.isInstanceOf[GeneratorLoader])
  }

  test("Get File Loader JPG") {
    val command = "--image ./images/jpg/prague.jpg"
    val loaderImplParser = new ImageLoaderImplParser
    val loadedImage = loaderImplParser.getLoader(command)
    assert(loadedImage.isInstanceOf[JPGFileLoader])
  }

  test("Get File Loader PNG") {
    val command = "--image ./images/png/white.png"
    val loaderImplParser = new ImageLoaderImplParser
    val loadedImage = loaderImplParser.getLoader(command)
    assert(loadedImage.isInstanceOf[PNGFileLoader])
  }

  test("Get File Loader JPEG") {
    val command = "--image ./images/jpg/red.jpeg"
    val loaderImplParser = new ImageLoaderImplParser
    val loadedImage = loaderImplParser.getLoader(command)
    assert(loadedImage.isInstanceOf[JPEGFileLoader])
  }
}
