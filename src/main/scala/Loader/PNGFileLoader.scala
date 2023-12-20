package Loader

/**
 * Loader of a PNG Image Files
 * @param path - a path where the file is located
 */
class PNGFileLoader(path: String) extends FileLoader(path, "(.*(png))".r){
}
