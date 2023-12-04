package Image

import Loader.GeneratorLoader
import org.scalatest.FunSuite

import scala.util.Random

class GeneratedImageTest extends FunSuite{
  def randomImage: RGBImage = GeneratorLoader.loadImage()

  test("Height is non zero") {
    assert(randomImage.getHeight != 0)
  }

  test("Width is non zero") {
    assert(randomImage.getWidth != 0)
  }
}
