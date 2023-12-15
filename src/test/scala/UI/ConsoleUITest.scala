package UI

import Converter.{AsciiConverter, Converter}
import Exporter.{Exporter, MixedExporter}
import Filter.{GreyScaleFilter, MixedFilter}
import Image.{FileImage, GeneratedImage, Image, RGBImage}
import _root_.Image.Pixel.RGBValue
import UI.controllers.Controller
import org.mockito.Mockito.{never, verify, verifyNoInteractions, verifyNoMoreInteractions}
import org.mockito.MockitoSugar.{mock, times, when}
import org.mockito.captor.ArgCaptor
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class ConsoleUITest extends FunSuite {


  test("[ConsoleUI] Basic conversion without filters") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image ./images/jpg/prague.jpg --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor,converterCaptor,filterCaptor,exportCaptor)

    assert(imageCaptor.value.isInstanceOf[FileImage])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Basic conversion with filters") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image ./images/jpg/prague.jpg --rotate +90 --invert --scale 4 --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor, converterCaptor, filterCaptor, exportCaptor)

    assert(imageCaptor.value.isInstanceOf[FileImage])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Basic conversion with random image") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image-random --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor, converterCaptor, filterCaptor, exportCaptor)

    assert(imageCaptor.value.isInstanceOf[GeneratedImage])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Fail when not correct image extension") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image ./images/jpg/prague.img --output-file ./images/ascii/converted.txt".split(" ")

    // Redirect error out stream
    val err = new ByteArrayOutputStream()
    System.setErr(new PrintStream(err))

    // Run command
    consoleUI.run(arguments)

    // Verify error
    val regex = "(\r\n|\n|\r)".r
    assert(regex.replaceAllIn(err.toString,"") == "Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!")
  }

  test("[ConsoleUI] Fail when not correct output argument") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image ./images/jpg/prague.jpg --output-toFile ./images/ascii/converted.txt".split(" ")

    // Redirect error out stream
    val err = new ByteArrayOutputStream()
    System.setErr(new PrintStream(err))

    // Run command
    consoleUI.run(arguments)

    // Verify error
    val regex = "(\r\n|\n|\r)".r
    assert(regex.replaceAllIn(err.toString, "") == "Invalid type of output! Use --output-console and/or --output-file path!")
  }

  test("[ConsoleUI] Fail when not correct filter") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image ./images/jpg/prague.jpg --scaled 4 --output-file ./images/ascii/converted.txt".split(" ")

    // Redirect error out stream
    val err = new ByteArrayOutputStream()
    System.setErr(new PrintStream(err))

    // Run command
    consoleUI.run(arguments)

    // Verify error
    val regex = "(\r\n|\n|\r)".r
    assert(regex.replaceAllIn(err.toString, "") == "Invalid filter used or invalid parameters of a filter given!")
  }

  test("[ConsoleUI] Convert default when bad table name") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image-random --table BadTable --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor, converterCaptor, filterCaptor, exportCaptor)

    assert(imageCaptor.value.isInstanceOf[GeneratedImage])
    assert(converterCaptor.value.isInstanceOf[AsciiConverter])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Convert using own linear table") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image-random --custom-table abcdefghijklmnopqrstuvwxyz --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor, converterCaptor, filterCaptor, exportCaptor)

    assert(imageCaptor.value.isInstanceOf[GeneratedImage])
    assert(converterCaptor.value.isInstanceOf[AsciiConverter])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Convert using Simple Burkes") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image-random --table SimpleBurkes --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor, converterCaptor, filterCaptor, exportCaptor)

    assert(imageCaptor.value.isInstanceOf[GeneratedImage])
    assert(converterCaptor.value.isInstanceOf[AsciiConverter])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Convert using Non Linear Table") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image-random --table Nonlinear --output-file ./images/ascii/converted.txt".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    consoleUI.run(arguments)

    verify(mockController).makeAscii(imageCaptor, converterCaptor, filterCaptor, exportCaptor)

    assert(imageCaptor.value.isInstanceOf[GeneratedImage])
    assert(converterCaptor.value.isInstanceOf[AsciiConverter])
    assert(filterCaptor.value.isInstanceOf[MixedFilter])
    assert(exportCaptor.value.isInstanceOf[MixedExporter])
  }

  test("[ConsoleUI] Export to console") {
    val mockController = mock[Controller]
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--image ./images/jpg/prague.jpg --output-console".split(" ")

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      consoleUI.run(arguments)
    }
    // Verify that it is not empty
    assert(out.size() != 0)
  }

  test("[Console UI] Show help"){
    val mockController = mock[Controller]
    when(mockController.showHelp()).thenReturn("HELP")
    val consoleUI = new ConsoleUI(mockController)
    val arguments = "--help".split(" ")

    val imageCaptor = ArgCaptor[RGBImage]
    val converterCaptor = ArgCaptor[AsciiConverter]
    val filterCaptor = ArgCaptor[GreyScaleFilter]
    val exportCaptor = ArgCaptor[Exporter]

    // Redirect out stream
    val out = new ByteArrayOutputStream()

    // Run command
    Console.withOut(out) {
      consoleUI.run(arguments)
    }

    verify(mockController,never()).makeAscii(imageCaptor,converterCaptor,filterCaptor,exportCaptor)
    verify(mockController,times(1)).showHelp()

    // Verify that it printed out correct help
    assert(out.toString() == "HELP")
  }
}
