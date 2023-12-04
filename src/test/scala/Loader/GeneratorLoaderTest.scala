package Loader

import org.scalatest.FunSuite
import Image.Pixel.RGBValue
import org.scalatest.Matchers.{a, be, convertToAnyShouldWrapper}

class GeneratorLoaderTest extends FunSuite {

  test("Height is between 200 & 900") {
    val randomImage = GeneratorLoader.loadImage()
    assert(randomImage.getHeight >= 200)
    assert(randomImage.getHeight < 900)
  }

  test("Width is between 200 & 900") {
    val randomImage = GeneratorLoader.loadImage()
    assert(randomImage.getWidth >= 200)
    assert(randomImage.getWidth < 900)
  }

  test("Image contains pixels") {
    val randomImage = GeneratorLoader.loadImage()
    for(i <- 0 until randomImage.getHeight) {
      for(j <- 0 until randomImage.getWidth) {
        randomImage.getPixel(i,j) should be (a[RGBValue])
      }
    }
  }
}
