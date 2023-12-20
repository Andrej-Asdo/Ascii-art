package Loader

/**
 * Loader of JPEG Image Files
 * @param path - a path where the file is located
 */
class JPEGFileLoader(path: String) extends FileLoader(path, "(.*(jpeg))".r) {

}
