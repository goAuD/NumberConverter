# NumberConverter

[![Java](https://img.shields.io/badge/Java-console%20app-orange?logo=openjdk&logoColor=white)](#tech-stack)
[![Status](https://img.shields.io/badge/status-practice%20project-lightgrey)](#about)

A small Java console project for practicing number conversion logic.

## About

`NumberConverter` is a small Java console project for converting numbers between different number systems.

It supports:

- decimal to binary conversion
- binary to decimal conversion
- decimal to hexadecimal conversion
- hexadecimal to decimal conversion
- hexadecimal to binary conversion
- binary to hexadecimal conversion
- basic input validation
- repeated input prompts until the user enters a valid value
- large-number conversion in `NumberConverterApp` via `BigInteger`

This repository is intentionally simple. It is a learning project, not a production application.

The repository license is not finalized yet.

## Tech Stack

- Java
- Console / CLI application
- No external dependencies

## Project Structure

- `src/NumberConverterApp.java` - main menu app for the available converter directions
- `src/IntegerToBinary.java` - standalone decimal-to-binary practice class
- `src/BinaryToInteger.java` - standalone binary-to-decimal practice class
- `src/IntegerToHexadecimal.java` - standalone decimal-to-hexadecimal practice class
- `src/HexadecimalToInteger.java` - standalone hexadecimal-to-decimal practice class
- `src/HexadecimalToBinary.java` - standalone hexadecimal-to-binary practice class
- `src/BinaryToHexadecimal.java` - standalone binary-to-hexadecimal practice class

## Run Locally

### Windows PowerShell

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out src\*.java
java -cp out NumberConverterApp
```

Run a standalone practice converter:

```powershell
java -cp out IntegerToBinary
java -cp out BinaryToInteger
java -cp out IntegerToHexadecimal
java -cp out HexadecimalToInteger
java -cp out HexadecimalToBinary
java -cp out BinaryToHexadecimal
```

### macOS / Linux

```bash
mkdir -p out
javac -d out src/*.java
java -cp out NumberConverterApp
```

Run a standalone practice converter:

```bash
java -cp out IntegerToBinary
java -cp out BinaryToInteger
java -cp out IntegerToHexadecimal
java -cp out HexadecimalToInteger
java -cp out HexadecimalToBinary
java -cp out BinaryToHexadecimal
```

## Example

Decimal to binary:

```text
Enter a decimal number: 10
1010
```

Binary to decimal:

```text
Enter a binary number: 1010
10
```

Decimal to hexadecimal:

```text
Enter a decimal number: 255
FF
```

Hexadecimal to decimal:

```text
Enter a hexadecimal number: FF
255
```

Hexadecimal to binary:

```text
Enter a hexadecimal number: FF
11111111
```

Binary to hexadecimal:

```text
Enter a binary number: 11111111
FF
```

Main app menu:

```text
Number Converter
1. Decimal to binary
2. Binary to decimal
3. Decimal to hexadecimal
4. Hexadecimal to decimal
5. Hexadecimal to binary
6. Binary to hexadecimal
0. Exit
Choose an option:
```

## Collaboration

This repo is open to small, focused improvements. Since this is a practice project, the goal is clarity and clean code rather than adding unnecessary complexity.

If you are reviewing or contributing:

- keep changes small and easy to review
- explain behavior changes in the commit or pull request
- prefer readability and input validation improvements
- discuss larger refactors before implementing them
- if a licensing detail matters for your contribution, discuss it first

For more detail, see [CONTRIBUTING.md](CONTRIBUTING.md).

## Ideas For Next Steps

- add unit tests
- consider sharing conversion logic between the main app and standalone practice classes
- add octal conversion if another number system is useful for practice
