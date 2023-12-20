package Loader

/**
 * Loader of JPG Image Files
 * @param path - a path where the file is located
 */
class JPGFileLoader(path: String) extends FileLoader(path, "(.*(jpg))".r){
}
