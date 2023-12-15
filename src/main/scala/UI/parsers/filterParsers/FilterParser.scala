package UI.parsers.filterParsers

import Filter.GreyScaleFilter

trait FilterParser {
  /**
   * Gets filters from arguments
   *
   * @param filterNames - the names and arguments of all filters that will be used
   * @return filter or filters that will be used
   * @throws IllegalArgumentException - a filter is not recognized
   */
  def getFilterFromNames(filterNames: Seq[String]): GreyScaleFilter
}
