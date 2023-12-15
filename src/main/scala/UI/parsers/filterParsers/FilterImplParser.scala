package UI.parsers.filterParsers
import Filter.{Filter, GreyScaleFilter, InvertFilter, MixedFilter, RotateFilter, ScaleFilter}

class FilterImplParser(filterRepository: Seq[SimpleFilterParser]) extends FilterParser {
  override def getFilterFromNames(filterNames: Seq[String]): GreyScaleFilter = {
    var filters = List[GreyScaleFilter]()
    for (filterName <- filterNames) {
      var foundFilter = false
      for (filter <- filterRepository) {
        filter.getFilterFromName(filterName) match {
          case Some(value) =>
            filters = filters.appended(value)
            foundFilter = true
          case _ =>
        }
      }
      if (!foundFilter) {
        throw new IllegalArgumentException("Invalid filter used or invalid parameters of a filter given!")
      }
    }
    new MixedFilter(filters)
  }

}
