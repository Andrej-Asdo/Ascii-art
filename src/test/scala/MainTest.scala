import UI.ConsoleUI
import UI.controllers.{BasicController, Controller}
import org.mockito.MockitoSugar.{mock, verify}
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}
import java.lang.System.lineSeparator


class MainTest extends FunSuite {
  test("Main Test of the Whole System to Console"){

    val arguments = "--image ./images/jpg/prague.jpg --output-console".split(" ")

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    Console.withOut(out) {
      // Run with arguments
      Main.Main.main(arguments)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
  }

  test("Main Test of the Whole System to Console No Arguments") {

    val arguments = "".split(" ")

    // Redirect err stream
    val err = new ByteArrayOutputStream()
    System.setErr(new PrintStream(err))

    // Run with arguments
    Main.Main.main(arguments)


    // Verify that it is not empty
    assert(err.size() != 0)
    assert(err.toString() == "Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!" + lineSeparator )
  }

  test("Main Test of the Whole System to Console With Invalid Filter") {

    val arguments = "".split("--image ./images/jpg/prague.jpg --stretch --output-console")

    // Redirect err stream
    val err = new ByteArrayOutputStream()
    System.setErr(new PrintStream(err))

    // Run with arguments
    Main.Main.main(arguments)


    // Verify that it is not empty
    assert(err.size() != 0)
    assert(err.toString() == "Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!" + lineSeparator)
  }
}
