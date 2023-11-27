package Image.Pixel

/**
 * A Ascii pixel
 * @param character - the character representation of a pixel
 */
case class AsciiValue (
                      val character: Char
              )
  extends Pixel
