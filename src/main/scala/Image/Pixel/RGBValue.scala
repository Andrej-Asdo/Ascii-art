package Image.Pixel

/**
 * A RGB Pixel
 * @param red - 0-255 value of red
 * @param green - 0-255 value of green
 * @param blue - 0-255 value of blue
 */
case class RGBValue(
                val red: Int,
                val green: Int,
                val blue: Int
                )
  extends Pixel
