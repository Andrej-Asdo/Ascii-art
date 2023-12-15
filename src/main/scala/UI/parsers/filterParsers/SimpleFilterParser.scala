package UI.parsers.filterParsers

import Filter.GreyScaleFilter

trait SimpleFilterParser {
  def getFilterFromName(filterName: String): Option[GreyScaleFilter]
}
