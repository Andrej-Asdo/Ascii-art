package Image

import org.scalatest.FunSuite

import java.io.File
import scala.util.Random

class FileImageTest extends FunSuite{
  def blackImage = new FileImage(new File("./images/jpg/black.jpg"))

  test("Height is non zero") {
    assert(blackImage.getHeight != 0)
  }

  test("Width is non zero") {
    assert(blackImage.getWidth != 0)
  }

  test("Random pixel is black") {
    val random = new Random
    // Get randomPixel from image
    val randPosition = (random.between(0, blackImage.getHeight), random.between(0, blackImage.getWidth))
    // Can be 0 --> need to fix this
    val randPixel = blackImage.getPixel(randPosition._1, randPosition._2)
    assert(randPixel.red == 0)
    assert(randPixel.blue == 0)
    assert(randPixel.green == 0)
  }

  test("All pixels are black") {
    for(col <- 0 until  10; row <- 0 until 10) {
      val randPixel = blackImage.getPixel(col, row)
      assert(randPixel.red == 0)
      assert(randPixel.blue == 0)
      assert(randPixel.green == 0)
    }
  }

  test("Get Pixel out of Bounds") {
    assertThrows[IndexOutOfBoundsException](blackImage.getPixel(1500, 2000))
    assertThrows[IndexOutOfBoundsException](blackImage.getPixel(1500, 20))
    assertThrows[IndexOutOfBoundsException](blackImage.getPixel(15, 2000))
  }

}
