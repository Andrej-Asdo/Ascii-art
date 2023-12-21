package Loader

import org.scalatest.FunSuite
import Image.Pixel.RGBValue
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.Matchers.{a, be, convertToAnyShouldWrapper}

import scala.util.Random

class GeneratorLoaderTest extends FunSuite {

  test("Dimensions are 342x354") {
    val random = mock[Random]
    when(random.between(200,900)).thenReturn(342,354)
    val generatorLoader = new GeneratorLoader(random)
    val randomImage = generatorLoader.loadImage()
    assert(randomImage.getHeight == 342)
    assert(randomImage.getWidth == 354)
  }

  test("Image contains good pixels") {
    val random = mock[Random]
    when(random.between(200, 900)).thenReturn(342, 354)
    when(random.between(0,255)).thenReturn(1)
    val generatorLoader = new GeneratorLoader(random)
    val randomImage = generatorLoader.loadImage()
    assert(randomImage.getHeight == 342)
    assert(randomImage.getWidth == 354)
    // Check random pixels
    val randomPixel = RGBValue(1,1,1)
    for (row <- 0 until randomImage.getHeight; col <- 0 until randomImage.getWidth) {
      assert(randomImage.getPixel(row,col) == randomPixel)
    }
  }

  test("Height is between 200 & 900") {
    val randomImage = new GeneratorLoader(new Random).loadImage()
    assert(randomImage.getHeight >= 200)
    assert(randomImage.getHeight < 900)
  }

  test("Width is between 200 & 900") {
    val randomImage = new GeneratorLoader(new Random).loadImage()
    assert(randomImage.getWidth >= 200)
    assert(randomImage.getWidth < 900)
  }

  test("Image contains pixels") {
    val randomImage = new GeneratorLoader(new Random).loadImage()
    for(i <- 0 until randomImage.getHeight) {
      for(j <- 0 until randomImage.getWidth) {
        randomImage.getPixel(i,j) should be (a[RGBValue])
      }
    }
  }
}
