package Image

import org.scalatest.FunSuite
import scala.util.Random

class GeneratedImageTest extends FunSuite{
    def randomImage = new GeneratedImage()

  test("Height is non zero") {
    assert(randomImage.getHeight != 0)
  }

  test("Width is non zero") {
    assert(randomImage.getWidth != 0)
  }

  test("Image contains pixels") {
    // Get randomPixel from image
    val rand = new Random
    val randPosition = (rand.between(0, randomImage.getHeight), rand.between(0, randomImage.getWidth))
    // Can be 0 --> need to fix this
    val randPixel = randomImage.getPixel(randPosition._1, randPosition._2)
    assert(randPixel.red != 0)
  }

}
