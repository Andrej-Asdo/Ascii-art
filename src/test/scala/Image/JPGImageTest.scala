package Image

import org.scalatest.FunSuite

import java.io.File
import scala.util.Random

class JPGImageTest extends FunSuite{
  def blackImage = new JPGImage(new File("./images/jpg/black.jpg"))

  test("Height is non zero") {
    assert(blackImage.getHeight != 0)
  }

  test("Width is non zero") {
    assert(blackImage.getWidth != 0)
  }

  test("Random pixel is black") {
    // Get randomPixel from image
    val randPixel = (Random.between(0, blackImage.getHeight), Random.between(0, blackImage.getWidth))
    // Can be 0 --> need to fix this
    assert(blackImage.getPixel(randPixel._1, randPixel._2) == 0)
  }

  test("All pixels are black") {
    for(col <- 0 until  50; row <- 0 until 50) {
      assert(blackImage.getPixel(col, row) == 0)
    }
  }

}
