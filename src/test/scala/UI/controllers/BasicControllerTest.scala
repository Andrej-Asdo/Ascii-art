package UI.controllers

import Converter.BasicConverter
import Exporter.FileExporter
import Filter.{InvertFilter, ScaleFilter}
import Image.{AsciiImage, GeneratedImage, GreyScaleImage, Image}
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoSugar.{mock, times}
import org.mockito.captor.ArgCaptor
import org.scalatest.FunSuite

class BasicControllerTest extends FunSuite{
  test("[Basic Controller] Test Show Help") {
    val basicController = new BasicController()
    assert(basicController.showHelp() ==
      "---Help---\n" +
      "+++ To run the program you must define input and output image:\n" +
      "++ Input:\n" +
      "--image-random for a random image\n" +
      "--image path for an existing file image (it must be either png,jpg or jpeg image!)\n" +
      "\n" +
      "++ Output:\n" +
      "--output-console to print the converted image to console\n" +
      "--output-file path the path must exist\n" +
      "\n\n" +
      "+++ You can apply also following filters:\n" +
      "++ Scale:\n" +
      "--scale {0.25,1,4} only these values are allowed - scales the image accordingly\n" +
      "++ Invert:\n" +
      "--invert inverts the colours of the image\n" +
      "++ Rotate:\n" +
      "--rotate {+- multiples of 90} rotates the image in given direction\n" +
      "\n\n" +
      "+++ You can apply also your own table\n" +
      "++ Paul Burkes Table\n" +
      "--table PaulBurkes\n" +
      "--table SimpleBurkes\n" +
      "++ Your own linear table\n" +
      "--custom-table {chars} chars that will be used to convert the image ranging from black to white (left to right)\n")
  }

  test("[Basic Controller] Make Ascii") {
    // Create Controller
    val basicController = new BasicController()

    // Mock dependencies
    val mockImage = mock[GeneratedImage]
    val mockConverter = mock[BasicConverter]
    val mockFilter = mock[InvertFilter]
    val mockOutput = mock[FileExporter]

    // Create captors
    val greyScaleCaptor = ArgCaptor[GreyScaleImage]
    val asciiCaptor = ArgCaptor[AsciiImage]

    basicController.makeAscii(mockImage,mockConverter,mockFilter,mockOutput)

    verify(mockConverter,times(1)).convertToGreyScale(mockImage)
    verify(mockConverter,times(1)).convertToAscii(greyScaleCaptor)
    verify(mockFilter,times(1)).filterGreyScaleImage(greyScaleCaptor)
    verify(mockOutput,times(1)).`export`(asciiCaptor)
  }
}
