# BinaryDecimalConverter

[![Java](https://img.shields.io/badge/Java-console%20app-orange?logo=openjdk&logoColor=white)](#tech-stack)
[![Status](https://img.shields.io/badge/status-practice%20project-lightgrey)](#about)

A small Java console app for converting decimal and binary numbers.

## About

`BinaryDecimalConverter` is a small Java console application for practicing number conversion logic.

It supports:

- decimal to binary conversion
- binary to decimal conversion
- basic input validation
- large-number conversion in the main app via `BigInteger`

This repository is intentionally simple. It is a learning project, not a production application.

The repository license is not finalized yet.

## Tech Stack

- Java
- Console / CLI application
- No external dependencies

## Project Structure

- `src/BinaryDecimalConverterApp.java` - main entry point
- `src/IntegerToBinary.java` - earlier standalone decimal-to-binary practice class
- `src/BinaryToInteger.java` - earlier standalone binary-to-decimal practice class

## Run Locally

### Windows PowerShell

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out src\*.java
java -cp out BinaryDecimalConverterApp
```

### macOS / Linux

```bash
mkdir -p out
javac -d out src/*.java
java -cp out BinaryDecimalConverterApp
```

## Example

Decimal to binary:

```text
Binary Decimal Converter
1. Decimal to binary
2. Binary to decimal
Choose an option (1 or 2): 1
Enter a non-negative decimal number: 10
Binary result: 1010
```

Binary to decimal:

```text
Binary Decimal Converter
1. Decimal to binary
2. Binary to decimal
Choose an option (1 or 2): 2
Enter a binary number: 1010
Decimal result: 10
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

- add an exit option and loop the menu until the user quits
- add unit tests
- support clearer error handling for edge cases
- reorganize the older practice classes if the project grows
