package UI.parsers.filterParsers
import Filter.{GreyScaleFilter, InvertFilter}

class InvertFilterParser extends SimpleFilterParser {
  private val commandName = "--invert"
  override def getFilterFromName(filterName: String): Option[GreyScaleFilter] = {
    if (filterName.contains(commandName))
      return Option(new InvertFilter())
    else
      return None
  }
}
