package Filter

import Image.{AsciiImage, GreyScaleImage}

class MixedFilter(filters: Seq[Filter]) extends Filter {
  override def filterGreyScaleImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    filters.foldLeft(greyScaleImage)((partialConvert, filter) => filter.filterGreyScaleImage(partialConvert))
  }
}
