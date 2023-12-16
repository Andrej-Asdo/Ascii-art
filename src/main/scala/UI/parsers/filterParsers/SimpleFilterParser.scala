package UI.parsers.filterParsers

import Filter.GreyScaleFilter
import UI.parsers.Parser

trait SimpleFilterParser extends Parser {
  /**
   * Get a filter from name
   * @param filterName a string representation of the name of the filter
   * @return return a filter if it corresponds to its name or None if not
   */
  def getFilterFromName(filterName: String): Option[GreyScaleFilter]
}
