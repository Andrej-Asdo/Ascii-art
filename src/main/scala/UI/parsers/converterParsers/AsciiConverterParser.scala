package UI.parsers.converterParsers
import Converter.AsciiConverter
import _root_.Converter.TransformationTable.LinearTable.{LinearTable, PaulBurkesTable, SimpleBurkes}
import _root_.Converter.TransformationTable.NonLinearTable.NonLinearTable
import Image.{AsciiImage, GreyScaleImage}

class AsciiConverterParser extends ConverterParser[GreyScaleImage,AsciiImage] {
  override def getConverter(command: String): AsciiConverter = {
    val customTableRegex = "--custom-table (.*)".r
    command match {
      // Use custom table
      case customTableRegex(table) =>
        new AsciiConverter(new LinearTable(table))
      // Use Simple Bourkes table
      case "--table SimpleBurkes" =>
        new AsciiConverter(SimpleBurkes)
      // Use non-linear table
      case "--table Nonlinear" =>
        new AsciiConverter(NonLinearTable)
      // Use Paul Burkes tables or default to it
      case "--table PaulBurkes" | _ =>
        new AsciiConverter(PaulBurkesTable)
    }
  }
}
