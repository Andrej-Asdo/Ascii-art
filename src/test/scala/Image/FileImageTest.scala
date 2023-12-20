package Image

import Loader.{FileLoader, JPGFileLoader}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

import java.io.{File, IOException}
import scala.util.Random

class FileImageTest extends FunSuite{
  def blackImage = new JPGFileLoader("./images/jpg/black.jpg").loadImage()

  test("[File Image] Height is non zero") {
    assert(blackImage.getHeight != 0)
  }

  test("[File Image] Width is non zero") {
    assert(blackImage.getWidth != 0)
  }

  test("[File Image] Random pixel is black") {
    val random = new Random
    // Get randomPixel from image
    val randPosition = (random.between(0, blackImage.getHeight), random.between(0, blackImage.getWidth))
    // Can be 0 --> need to fix this
    val randPixel = blackImage.getPixel(randPosition._1, randPosition._2)
    assert(randPixel.red == 0)
    assert(randPixel.blue == 0)
    assert(randPixel.green == 0)
  }

  test("[File Image] All pixels are black") {
    for(col <- 0 until  10; row <- 0 until 10) {
      val randPixel = blackImage.getPixel(col, row)
      assert(randPixel.red == 0)
      assert(randPixel.blue == 0)
      assert(randPixel.green == 0)
    }
  }

  test("[File Image] Get Pixel out of Bounds") {
    assertThrows[IndexOutOfBoundsException](blackImage.getPixel(1500, 2000))
    assertThrows[IndexOutOfBoundsException](blackImage.getPixel(1500, 20))
    assertThrows[IndexOutOfBoundsException](blackImage.getPixel(15, 2000))
  }

}
