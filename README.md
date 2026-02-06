# Ascii Art

A small Scala/sbt command-line utility that converts images to ASCII art.

This project loads images (PNG/JPG/JPEG or random-generated), applies greyscale conversion and optional filters, converts to ASCII using configurable transformation tables, and exports the result to console and/or files.

## Quick summary

- **Language:** Scala
- **Build tool:** sbt
- **Run target:** `Main` (console UI)

## Requirements

- Java JDK 8+ installed and on `PATH`.
- sbt installed (https://www.scala-sbt.org/).

## Build & run

From the project root (where `build.sbt` is):

```bash
sbt compile
sbt run -- <app-arguments>
```

Example (convert a PNG and print to console and write to file):

```bash
sbt "run --image images/png/example.png --table PaulBurkes --invert --rotate 90 --output-console --output-file output.txt"
```

Example (random generated image):

```bash
sbt "run --image-random --scale 0.5 --output-console"
```

Note: on Windows PowerShell you may need to use double quotes around the entire `run` invocation as shown above.

## Command-line options

- `--help` : show help text.
- `--image <path.png|path.jpg|path.jpeg>` : load an image from file.
- `--image-random` : generate a random image.
- `--table PaulBurkes|SimpleBurkes|Nonlinear` : choose a transformation table (defaults to `PaulBurkes`).
- `--custom-table <chars>` : provide a custom linear transformation table string.
- `--invert` : apply invert filter.
- `--rotate <degrees>` : rotate image (integer degrees, e.g. `90` or `-90`).
- `--scale <factor>` : scale image by factor (e.g. `0.5` to shrink by half).
- `--output-console` : print ASCII to console.
- `--output-file <path>` : write ASCII output to a file. Can be provided multiple times.

Flags that are not recognized will result in an `IllegalArgumentException` printed to stderr.

## Examples

- Convert an existing JPEG, use the default table and print to console:

```bash
sbt "run --image images/jpg/photo.jpg --output-console"
```

- Convert with a custom linear table, apply invert and save to `images/ascii/converted.txt`:

```bash
sbt "run --image images/png/logo.png --custom-table \"@%#*+=-:. \" --invert --output-file images/ascii/converted.txt"
```

## Run tests

Run unit tests with:

```bash
sbt test
```

## Project layout (important files)

- `src/main/scala/Main.scala` : application entrypoint.
- `src/main/scala/UI/ConsoleUI.scala` : console UI and parser wiring.
- `src/main/scala/UI/parsers/` : CLI parsers for loaders, filters, converters, exporters.
- `src/main/scala/Loader/` : image loaders (PNG/JPG/JPEG/generator).
- `src/main/scala/Exporter/` : exporters (console/file/mixed).

## Where to find sample images

- See the `images/png/` and `images/jpg/` folders for example inputs.
- Converted ASCII examples may be placed in `images/ascii/`.
