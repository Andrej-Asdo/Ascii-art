package UI.parsers.filterParsers
import Filter.{GreyScaleFilter, InvertFilter, MixedFilter, RotateFilter, ScaleFilter}

class FilterImplParser extends FilterParser {
  override def getFilterFromNames(filterNames: Seq[String]): GreyScaleFilter = {
    var filters = List[GreyScaleFilter]()
    for (filter <- filterNames) {
      if (filter.contains("--invert"))
        filters = filters.appended(new InvertFilter())

      else if (filter.startsWith("--rotate ")) {
        // Make regex
        val rotateRegex = "--rotate ([+,-]*[0-9]+)".r
        filter match {
          case rotateRegex(value) =>
            filters = filters.appended(new RotateFilter(value.toInt))
        }
      }

      else if (filter.startsWith("--scale ")) {
        // Make regex
        val scaleRegex = "--scale ([0-9]+[.]*[0-9]*)".r
        filter match {
          case scaleRegex(value) =>
            filters = filters.appended(new ScaleFilter(value.toDouble))
        }
      }

      else {
        throw new IllegalArgumentException("Invalid filter used or invalid parameters of a filter given!")
      }

    }
    new MixedFilter(filters)
  }
}
