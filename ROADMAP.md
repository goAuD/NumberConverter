# Roadmap

This roadmap describes where `NumberConverter` can grow next. The goal is not to become a random pile of calculators. The goal is to build a clear, useful learning tool for number systems, binary thinking, and IPv4 subnetting.

The project should stay beginner-friendly. Each feature should be easy to run, easy to read, and easy to explain.

## Product Direction

`NumberConverter` should become an educational Java CLI tool for:

- number system conversion
- binary and hexadecimal reasoning
- IPv4 prefix and subnet practice
- step-by-step explanations for students and junior developers

The strongest market gap is not "another converter". Many tools already convert values quickly. The stronger angle is a converter that also explains the thinking behind the result.

## Phase 1 - Stable Learning Core

Goal: keep the current converter set stable and consistent.

Scope:

- Keep the standalone converter classes readable.
- Keep class names in English and variable names in German.
- Keep input validation consistent across classes.
- Keep the main app menu aligned with the standalone classes.
- Keep README examples up to date.

Current coverage:

- decimal to binary
- binary to decimal
- decimal to hexadecimal
- hexadecimal to decimal
- hexadecimal to binary
- binary to hexadecimal
- CIDR prefix to usable hosts

Definition of done:

- Every class compiles.
- Every standalone class can run directly.
- `NumberConverterApp` exposes every supported conversion.
- README examples match real program output.

## Phase 2 - Explain Mode

Goal: make the tool useful for learning, not only for answers.

Ideas:

- Add a quick mode that prints only the result.
- Add an explain mode that prints the calculation steps.
- Show formulas for subnet calculations.
- Show repeated division steps for decimal to binary and decimal to hexadecimal.
- Show place-value steps for binary to decimal and hexadecimal to decimal.

Example:

```text
Input: /28
Host bits = 32 - 28 = 4
Total addresses = 2^4 = 16
Usable hosts = 16 - 2 = 14
```

Why this matters:

- Students can check how an answer was calculated.
- Teachers can use the output as a worked example.
- Beginners can compare their manual calculation with the tool.

## Phase 3 - IPv4 Subnet Toolkit

Goal: expand the networking part in a focused way.

Useful additions:

- CIDR prefix to subnet mask
- subnet mask to CIDR prefix
- CIDR prefix to total addresses and usable hosts
- IP address and prefix to network address
- IP address and prefix to broadcast address
- IP address and prefix to first and last usable host

Example future input:

```text
192.168.0.1/28
```

Example future output:

```text
Network address: 192.168.0.0
Broadcast address: 192.168.0.15
First usable host: 192.168.0.1
Last usable host: 192.168.0.14
Usable hosts: 14
```

Why this matters:

- Networking students often need to connect binary conversion with subnetting.
- Many tools give results, but fewer tools teach the calculation path clearly.

## Phase 4 - Practice Mode

Goal: turn the app into a study tool.

Ideas:

- Random conversion questions.
- Random CIDR prefix questions.
- Immediate feedback after each answer.
- Show the correct solution and a short explanation.
- Track correct and incorrect answers during one session.

Example:

```text
Question: Convert decimal 192 to binary.
Your answer: 11000000
Correct.
```

Harder example:

```text
Question: How many usable hosts are available in /27?
Your answer: 32
Incorrect.
Correct answer: 30
Explanation: 32 - 27 = 5 host bits, 2^5 = 32, 32 - 2 = 30.
```

Why this matters:

- Practice mode gives the project a clearer identity.
- It helps users build speed and confidence.
- It makes the tool more than a passive calculator.

## Phase 5 - Developer-Friendly CLI

Goal: make the app useful outside the interactive menu.

Possible command style:

```powershell
java -cp out NumberConverterApp binary 10
java -cp out NumberConverterApp hex 255
java -cp out NumberConverterApp hosts /28
java -cp out NumberConverterApp hosts /28 --explain
```

Useful options:

- `--explain`
- `--quiet`
- `--help`
- `--version`

Why this matters:

- Developers often want quick command-line answers.
- A scriptable CLI is easier to integrate into workflows.
- It gives the project a practical use beyond learning.

## Phase 6 - Code Quality and Tests

Goal: make the project safe to change.

Useful improvements:

- Extract shared conversion logic into reusable methods.
- Keep standalone classes as readable practice files.
- Add a small test runner or JUnit setup.
- Test normal cases, invalid input, zero, and boundary values.
- Add examples for every converter.

Important test cases:

- `10 -> 1010`
- `1010 -> 10`
- `255 -> FF`
- `FF -> 255`
- `/28 -> 14 usable hosts`
- `/31 -> 0 usable hosts` for the current classic learning rule
- `/32 -> 0 usable hosts`

Why this matters:

- The project is growing.
- Tests prevent small changes from breaking old converters.
- A clean structure makes the app easier to extend.

## Phase 7 - Optional UI or Web Version

Goal: only add a UI after the CLI is solid.

Possible directions:

- Simple Java desktop UI.
- Small web version.
- Copy buttons for results.
- Visual bit grouping.
- Step-by-step panels.

This should wait until the core logic is stable. A polished UI built on messy logic would slow the project down.

## Long-Term Identity

The project should be positioned as:

```text
NumberConverter: an educational Java CLI tool for number systems, binary logic, and IPv4 subnetting.
```

That direction is specific enough to be useful and broad enough to grow.
