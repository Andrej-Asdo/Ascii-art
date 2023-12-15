package UI.parsers.filterParsers
import Filter.{GreyScaleFilter, ScaleFilter}

class ScaleFilterParser extends SimpleFilterParser{
  private val scaleRegex = "--scale ([0-9]+[.]*[0-9]*)".r
  override def getFilterFromName(filterName: String): Option[GreyScaleFilter] = {
    filterName match {
      case scaleRegex(value) =>
        Option(new ScaleFilter(value.toDouble))
      case _ =>
        None
    }
  }
}
