package Filter

import Image.{AsciiImage, GreyScaleImage}

/**
 * A set of more filters that can be applied one by one on the image
 * @param filters the filters that will be applied
 */
class MixedFilter(filters: Seq[GreyScaleFilter]) extends GreyScaleFilter {
  override def filterImage(greyScaleImage: GreyScaleImage): GreyScaleImage = {
    filters.foldLeft(greyScaleImage)((partialConvert, filter) => filter.filterImage(partialConvert))
  }
}
