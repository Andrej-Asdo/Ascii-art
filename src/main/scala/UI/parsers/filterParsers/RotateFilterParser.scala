package UI.parsers.filterParsers
import Filter.{GreyScaleFilter, RotateFilter}

class RotateFilterParser extends SimpleFilterParser {
  private val rotateRegex = "--rotate ([+,-]*[0-9]+)".r
  override def getFilterFromName(filterName: String): Option[GreyScaleFilter] = {
    // Make regex
    filterName match {
      case rotateRegex(value) =>
        Option(new RotateFilter(value.toInt))
      case _ =>
        None
    }
  }
}
