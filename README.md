# Object Oriented Programming Through Java — Lab Record

[![Language](https://img.shields.io/badge/language-Java-007396.svg)](https://www.java.com/)
[![JDK](https://img.shields.io/badge/JDK-8%2B-blue.svg)](https://adoptium.net/)
[![Dependencies](https://img.shields.io/badge/dependencies-JDK%20standard%20library%20only-orange.svg)](https://docs.oracle.com/en/java/javase/)
[![Platform](https://img.shields.io/badge/platform-Windows%20%7C%20Linux%20%7C%20macOS-lightgrey.svg)](#prerequisites)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)

A complete, self-contained collection of Java programs written for the **Object Oriented
Programming Through Java Laboratory** (II B.Tech — Semester I). Every program is a single
`.java` file with its own `main` method, depends only on the JDK standard library, and
compiles and runs independently.

---

## Table of Contents

- [Object Oriented Programming Through Java — Lab Record](#object-oriented-programming-through-java--lab-record)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
  - [Repository Structure](#repository-structure)
  - [Prerequisites](#prerequisites)
  - [Compiling and Running](#compiling-and-running)
    - [File Names vs. Class Names](#file-names-vs-class-names)
    - [Running a Single Program](#running-a-single-program)
    - [Compiling the Program: User-Defined Packages](#compiling-the-program-user-defined-packages)
    - [Running Every Program](#running-every-program)
  - [Program Reference](#program-reference)
    - [1 — Primitive Defaults and Quadratic Roots](#1--primitive-defaults-and-quadratic-roots)
    - [2 — Searching, Sorting and StringBuffer](#2--searching-sorting-and-stringbuffer)
    - [3 — Classes, Methods and Constructors](#3--classes-methods-and-constructors)
    - [4 — Inheritance and Abstract Classes](#4--inheritance-and-abstract-classes)
    - [5 — super, Interfaces and Runtime Polymorphism](#5--super-interfaces-and-runtime-polymorphism)
    - [6 — Exception Handling](#6--exception-handling)
    - [7 — Multithreading](#7--multithreading)
    - [8 — User-Defined Packages](#8--user-defined-packages)
  - [Concept Summary](#concept-summary)
  - [Known Issues](#known-issues)
  - [Coding Conventions](#coding-conventions)
  - [Author(s)](#authors)
  - [License](#license)

---

## Overview

The programs cover the language fundamentals, the four object-oriented pillars, and the
error-handling and concurrency facilities built on top of them:

| Theme                       | Experiments                                                               |
| :-------------------------- | :------------------------------------------------------------------------ |
| Language fundamentals       | Default values of primitive types, quadratic roots from the discriminant  |
| Algorithms and strings      | Binary search, bubble sort, `StringBuffer` deletion methods               |
| Encapsulation               | Class mechanism, method overloading, constructors, constructor overloading |
| Inheritance and abstraction | Single inheritance, multilevel inheritance, abstract classes              |
| Polymorphism                | `super` keyword, interfaces, dynamic method dispatch                      |
| Exception handling          | `try`/`catch`, multiple catch clauses, built-in and user-defined exceptions |
| Multithreading              | Thread creation, `isAlive()`/`join()`, daemon threads, producer–consumer  |
| Packages                    | Declaring a user-defined package and importing it from a driver class    |

## Repository Structure

```
java_2-1/
├── 1a_primitive.java                 # Default values of the primitive data types
├── 1b_quad_eq.java                   # Quadratic roots from the discriminant D
├── 2a_binary_search.java             # Binary search over a sorted array
├── 2b_bubble_sort.java               # Bubble sort
├── 2c_stringbuffer_remchar.java      # StringBuffer: delete() and deleteCharAt()
├── 3a_class_mechanism.java           # Class definition, object creation, method invocation
├── 3b_method_overloading.java        # Method overloading by parameter list
├── 3c_constructor.java               # Constructor: object initialisation
├── 3d_constructor_overloading.java   # Constructor overloading
├── 4a_single_inheritance.java        # Single inheritance and constructor chaining
├── 4b_multilevel_inheritance.java    # Multilevel inheritance: A → B → C
├── 4c_abstract_class_area.java       # Abstract class: areas of different shapes
├── 5a_super_keyword.java             # super(...) to invoke the parent constructor
├── 5b_interface.java                 # Interfaces, interface extension, multiple inheritance
├── 5c_runtime_polymorphism.java      # Dynamic method dispatch via a superclass reference
├── 6a_exception_handling.java        # try / catch and ArithmeticException
├── 6b_multiple_catch_clauses.java    # Multiple catch clauses on one try block
├── 6c_builtin_exceptions.java        # Java built-in (unchecked) exceptions
├── 6d_user_defined_exception.java    # Custom exception extending Exception
├── 7a_threads.java                   # Three threads by extending Thread
├── 7b_alive_join.java                # isAlive() and join()
├── 7c_daemon_threads.java            # setDaemon() and isDaemon()
├── 7d_producer_consumer.java         # wait() / notify() with synchronized methods
├── 8a_user_defined/                  # Experiment 8 — self-contained package demo
│   ├── 8a_user_defined.java          #   Driver: imports mypack1.Demo1 and mypack1.Demo2
│   └── mypack1/                      #   The user-defined package
│       ├── Demo1.java                #     package mypack1; public class Demo1
│       └── Demo2.java                #     package mypack1; public class Demo2
├── LICENSE
└── README.md
```

> **Note on numbering:** file names follow the experiment numbers in the lab manual. The
> `a`/`b`/`c`/`d` suffixes denote the parts of a single experiment — experiment 1 has two
> parts, experiment 7 has four.
>
> Experiments 1–7 are flat files in the repository root. Experiment 8 needs a directory of
> its own, because a package declaration has to match the directory it lives in — see
> [Compiling the Program: User-Defined Packages](#compiling-the-program-user-defined-packages).

## Prerequisites

| Requirement          | Details                                                                       |
| :------------------- | :---------------------------------------------------------------------------- |
| **JDK**              | JDK 8 or newer — developed and verified on OpenJDK 26                         |
| **Standard library** | `java.lang` and `java.util.Scanner` only — no third-party dependencies        |
| **Tooling**          | `javac` and `java` from the command line; no build tool, no IDE project files |

Verify your toolchain — both commands must report the same major version:

```bash
java -version
javac -version
```

If `javac` is missing, you have a JRE rather than a JDK. Install a full JDK from
[Adoptium](https://adoptium.net/) or
[Oracle](https://www.oracle.com/java/technologies/downloads/), then ensure its `bin` directory
is on your `PATH`.

## Compiling and Running

### File Names vs. Class Names

Java normally requires a file to be named after the `public` class it contains. **No class in
this repository is declared `public`**, so the file names are free to follow the lab-manual
numbering instead. The consequence is that the name you pass to `javac` is *not* the name you
pass to `java`:

| File                                                                 | Class with `main` |
| :------------------------------------------------------------------- | :---------------- |
| [`1a_primitive.java`](1a_primitive.java)                             | `OneA`            |
| [`1b_quad_eq.java`](1b_quad_eq.java)                                 | `OneB1`           |
| [`2a_binary_search.java`](2a_binary_search.java)                     | `TwoA`            |
| [`2b_bubble_sort.java`](2b_bubble_sort.java)                         | `TwoB`            |
| [`2c_stringbuffer_remchar.java`](2c_stringbuffer_remchar.java)       | `TwoC`            |
| [`3a_class_mechanism.java`](3a_class_mechanism.java)                 | `ThreeA`          |
| [`3b_method_overloading.java`](3b_method_overloading.java)           | `ThreeB`          |
| [`3c_constructor.java`](3c_constructor.java)                         | `ThreeC`          |
| [`3d_constructor_overloading.java`](3d_constructor_overloading.java) | `ThreeD`          |
| [`4a_single_inheritance.java`](4a_single_inheritance.java)           | `FourA`           |
| [`4b_multilevel_inheritance.java`](4b_multilevel_inheritance.java)   | `FourB`           |
| [`4c_abstract_class_area.java`](4c_abstract_class_area.java)         | `FourC`           |
| [`5a_super_keyword.java`](5a_super_keyword.java)                     | `FiveA`           |
| [`5b_interface.java`](5b_interface.java)                             | `FiveB`           |
| [`5c_runtime_polymorphism.java`](5c_runtime_polymorphism.java)       | `FiveC`           |
| [`6a_exception_handling.java`](6a_exception_handling.java)           | `SixA`            |
| [`6b_multiple_catch_clauses.java`](6b_multiple_catch_clauses.java)   | `SixB`            |
| [`6c_builtin_exceptions.java`](6c_builtin_exceptions.java)           | `SixC`            |
| [`6d_user_defined_exception.java`](6d_user_defined_exception.java)   | `SixD`            |
| [`7a_threads.java`](7a_threads.java)                                 | `SevenA`          |
| [`7b_alive_join.java`](7b_alive_join.java)                           | `SevenB`          |
| [`7c_daemon_threads.java`](7c_daemon_threads.java)                   | `SevenC`          |
| [`7d_producer_consumer.java`](7d_producer_consumer.java)             | `SevenD`          |
| [`8a_user_defined/8a_user_defined.java`](8a_user_defined/8a_user_defined.java) | `Test` |

> `1b_quad_eq.java` declares `OneB1` rather than `OneB`; the trailing `1` is an artefact of the
> manual and is preserved here so the source stays unmodified.

**Compile each program into its own output directory.** Many files reuse the helper class names
`A`, `B` and `C` for different purposes, so compiling two of them into the same directory is a
hard error:

```
3c_constructor.java:18: error: duplicate class: A
```

### Running a Single Program

```bash
# Linux / macOS
javac -d out/ThreeB 3b_method_overloading.java
java -cp out/ThreeB ThreeB
```

```powershell
# Windows (PowerShell)
javac -d out\ThreeB 3b_method_overloading.java
java -cp out\ThreeB ThreeB
```

On JDK 11 and newer the single-file source launcher (`java 1a_primitive.java`) works **only**
for `1a`, `1b`, `2a`, `2b` and `2c`, where the class holding `main` is the first class in the
file. Every other program declares helper classes first, so the launcher fails with
`error: can't find class: ...`. Use the two-step `javac`/`java` form throughout.

### Compiling the Program: User-Defined Packages

Experiment 8 is the one program that is not a single flat file. `mypack1/Demo1.java` and
`mypack1/Demo2.java` both begin with `package mypack1;`, and the driver imports them:

```java
import mypack1.Demo1;
import mypack1.Demo2;
```

A package name must match the directory path that holds it, relative to the root of the
source tree. That root is `8a_user_defined/`, so **every command below must be run from
inside that directory.** Invoking `javac` from the repository root instead fails:

```
8a_user_defined/8a_user_defined.java:3: error: package mypack1 does not exist
import mypack1.Demo1;
```

The source file closes with the compile recipe as printed in the lab manual:

```text
Compiling the program:
>javac Test.java
>java Test
Output:
welcome Demo1
welcome Demo2
```

The class is indeed `Test`, but the **file** is `8a_user_defined.java`, so `javac Test.java`
reports `error: file not found: Test.java`. Compile the file, then run the class:

```bash
# Linux / macOS — from inside 8a_user_defined/
cd 8a_user_defined
javac -d out 8a_user_defined.java
java -cp out Test
```

```powershell
# Windows (PowerShell) — from inside 8a_user_defined\
cd 8a_user_defined
javac -d out 8a_user_defined.java
java -cp out Test
```

One `javac` invocation is enough: the compiler follows the `import` statements, finds
`mypack1/Demo1.java` and `mypack1/Demo2.java` on the implicit source path, and compiles them
too. The output directory mirrors the package structure:

```
out/
├── Test.class
└── mypack1/
    ├── Demo1.class
    └── Demo2.class
```

To compile the package explicitly first — closer to how the manual describes it, and the form
you need once the package is shared between programs — build the package, then put it on the
class path for the driver:

```bash
javac -d out mypack1/Demo1.java mypack1/Demo2.java
javac -d out -cp out 8a_user_defined.java
java -cp out Test
```

Either route produces the same result:

```text
welcome Demo1
welcome Demo2
```

### Running Every Program

The scripts below build each program into `out/<ClassName>/` and run it. They exclude the three
programs that read from standard input (`1b`, `2a`, `2b`), the two long-running thread demos
(`7a`, `7b`, roughly 30 seconds each), and experiment `8a`, which must be compiled from its own
directory — run those individually.

```bash
# Linux / macOS
while read -r src main; do
    printf '===== %s =====\n' "$src"
    javac -d "out/$main" "$src" && java -cp "out/$main" "$main"
done <<'EOF'
1a_primitive.java                OneA
2c_stringbuffer_remchar.java     TwoC
3a_class_mechanism.java          ThreeA
3b_method_overloading.java       ThreeB
3c_constructor.java              ThreeC
3d_constructor_overloading.java  ThreeD
4a_single_inheritance.java       FourA
4b_multilevel_inheritance.java   FourB
4c_abstract_class_area.java      FourC
5a_super_keyword.java            FiveA
5b_interface.java                FiveB
5c_runtime_polymorphism.java     FiveC
6a_exception_handling.java       SixA
6b_multiple_catch_clauses.java   SixB
6c_builtin_exceptions.java       SixC
6d_user_defined_exception.java   SixD
7c_daemon_threads.java           SevenC
7d_producer_consumer.java        SevenD
EOF
```

```powershell
# Windows (PowerShell)
$programs = [ordered]@{
    '1a_primitive.java'               = 'OneA'
    '2c_stringbuffer_remchar.java'    = 'TwoC'
    '3a_class_mechanism.java'         = 'ThreeA'
    '3b_method_overloading.java'      = 'ThreeB'
    '3c_constructor.java'             = 'ThreeC'
    '3d_constructor_overloading.java' = 'ThreeD'
    '4a_single_inheritance.java'      = 'FourA'
    '4b_multilevel_inheritance.java'  = 'FourB'
    '4c_abstract_class_area.java'     = 'FourC'
    '5a_super_keyword.java'           = 'FiveA'
    '5b_interface.java'               = 'FiveB'
    '5c_runtime_polymorphism.java'    = 'FiveC'
    '6a_exception_handling.java'      = 'SixA'
    '6b_multiple_catch_clauses.java'  = 'SixB'
    '6c_builtin_exceptions.java'      = 'SixC'
    '6d_user_defined_exception.java'  = 'SixD'
    '7c_daemon_threads.java'          = 'SevenC'
    '7d_producer_consumer.java'       = 'SevenD'
}
foreach ($src in $programs.Keys) {
    $main = $programs[$src]
    Write-Host "===== $src ====="
    javac -d "out\$main" $src
    if ($LASTEXITCODE -eq 0) { java -cp "out\$main" $main }
}
```

All twenty-four programs compile without warnings and run cleanly under OpenJDK 26. Add `out/`
to your `.gitignore` so class files stay out of version control.

---

## Program Reference

### 1 — Primitive Defaults and Quadratic Roots

**Files:** [`1a_primitive.java`](1a_primitive.java), [`1b_quad_eq.java`](1b_quad_eq.java)

**1a — Default values.** *Input: none.* The primitive types are declared as `static` fields and
printed without ever being assigned. Instance and class fields — unlike local variables, which
the compiler refuses to read before assignment — are zero-initialised by the JVM, which is
exactly what the program demonstrates.

```text
the default values of primitive datatypes are:
byte:0
short:0
int:0
long:0
float:0.0
double:0.0
char:
Boolean:null
```

The `char` line looks blank because the default `'\u0000'` is a non-printing character, and the
last line reads `null` because that field is declared as the wrapper `Boolean` rather than the
primitive `boolean` — see [Known Issues](#known-issues).

**1b — Quadratic roots.** *Input: three integers `a`, `b`, `c`.* Computes the discriminant
`D = b² − 4ac` and branches on its sign: `D > 0` gives two distinct real roots via
`(−b ± √D) / 2a`, `D = 0` gives one repeated root, and `D < 0` reports imaginary roots without
computing them.

```text
Given quadratic equation:ax^2+bx+c
Enter a:1
Enter b:-3
Enter c:2
Roots are real and unequal
First root is:2.0
Second root is:1.0
```

### 2 — Searching, Sorting and StringBuffer

**Files:** [`2a_binary_search.java`](2a_binary_search.java),
[`2b_bubble_sort.java`](2b_bubble_sort.java),
[`2c_stringbuffer_remchar.java`](2c_stringbuffer_remchar.java)

**2a — Binary search.** *Input: element count, the elements in ascending order, then the key.*
Compares the key against the middle element and discards the half that cannot contain it,
halving the search interval on each iteration. **The input must already be sorted** or the
result is meaningless — and that precondition is the trade-off being taught: binary search is
exponentially faster than a linear scan, but only over data someone has already paid to sort.

```text
Enter total number of elements:
5
Enter elements in sorted order:
11 22 33 44 55
Enter the search value:
33
number found
```

**2b — Bubble sort.** *Input: element count, then the elements.* Compares each element with its
neighbour and swaps them when out of order, so the largest unsorted value bubbles to the end of
the array on every pass.

```text
Enter total number of elements:
6
Enter elements:
64 34 25 12 22 11
The sorted elements are:
        11      12      22      25      34      64
```

**2c — StringBuffer deletion.** *Input: none.* `String` is immutable and fixed-length;
`StringBuffer` is a growable, writable character sequence, so it can be edited in place. The
program shows three deletions: `delete(0, 6)` removes a half-open range, `delete(0, length())`
clears the buffer entirely, and `deleteCharAt(0)` removes a single character.

```text
World
Some Content

ello World
```

The blank third line is the emptied buffer.

### 3 — Classes, Methods and Constructors

**Files:** [`3a_class_mechanism.java`](3a_class_mechanism.java),
[`3b_method_overloading.java`](3b_method_overloading.java),
[`3c_constructor.java`](3c_constructor.java),
[`3d_constructor_overloading.java`](3d_constructor_overloading.java) · **Input:** none

The four parts build up the class construct one feature at a time, all over the same
rectangle-area example so the change at each step is isolated.

| Part | Adds                      | Point being made                                                        |
| :--- | :------------------------ | :---------------------------------------------------------------------- |
| `3a` | Class, object, method     | A class is a blueprint; `new` allocates an instance that owns its fields |
| `3b` | A second `area(int, int)` | Overloads are distinguished by parameter list, resolved at compile time  |
| `3c` | A no-argument constructor | Initialisation belongs in the constructor, not in field declarations     |
| `3d` | A second `A(int, int)`    | Constructor overloading — one class, several ways to be built            |

```text
# 3b — area() then area(5, 20)
The area is: 200
The area is: 100

# 3d — A() then A(30, 40)
The area is: 200
The area is: 1200
```

Overload resolution here is entirely a compile-time decision based on the *declared* argument
types. Contrast this with experiment
[5c](#5--super-interfaces-and-runtime-polymorphism), where the choice is deferred to run time.

### 4 — Inheritance and Abstract Classes

**Files:** [`4a_single_inheritance.java`](4a_single_inheritance.java),
[`4b_multilevel_inheritance.java`](4b_multilevel_inheritance.java),
[`4c_abstract_class_area.java`](4c_abstract_class_area.java) · **Input:** none

**4a and 4b — Constructor chaining.** `B extends A` in `4a`; `C extends B extends A` in `4b`.
Neither subclass calls `super()` explicitly, yet the parent constructors still run: the compiler
inserts an implicit no-argument `super()` as the first statement of every constructor that does
not begin with one. Construction therefore proceeds from the root of the hierarchy downwards,
and the print order proves it.

```text
# 4b
Inside A's Constructor
Inside B's Constructor
Inside C's Constructor
```

**4c — Abstract class.** `shape` declares `abstract double area()` with no body, which makes the
class itself abstract and uninstantiable, and forces `rectangle`, `triangle` and `square` to each
supply an implementation. This is abstraction in the strict sense: the base class fixes *what*
every shape must be able to do without committing to *how*.

```text
The area of rectangle is: 31.25
The area of triangle is: 13.65
The area of square is: 26.0
```

> The square figure is wrong — see [Known Issues](#known-issues).

### 5 — super, Interfaces and Runtime Polymorphism

**Files:** [`5a_super_keyword.java`](5a_super_keyword.java),
[`5b_interface.java`](5b_interface.java),
[`5c_runtime_polymorphism.java`](5c_runtime_polymorphism.java) · **Input:** none

**5a — `super(...)`.** `A` has no no-argument constructor, so the implicit `super()` of
experiment 4 would not compile here. `B(int, int, int)` must call `super(u, v)` explicitly as its
first statement to initialise the inherited `l` and `b` before setting its own `h`.

```text
The vol. is: 18000
```

**5b — Interfaces.** Answers the question posed by the experiment: *what kind of inheritance can
be achieved?* A class may extend only one class but implement any number of interfaces, and
interfaces may extend one another — so interfaces are how Java offers multiple inheritance of
*type* while avoiding the diamond ambiguity of multiple inheritance of *state*. Here `E extends
D`, `B extends A implements E`, and `C extends B`, so a single `C` object answers to four methods
drawn from two separate hierarchies.

```text
This is in display method
This is in show method
This is in callme method
This is in call method
```

**5c — Dynamic method dispatch.** One reference variable `A ref` is pointed in turn at a `C`, a
`B` and an `A`. Each `ref.display()` call is identical in the source; which override runs is
decided by the type of the *object*, at run time, not by the type of the reference.

```text
Inside C class
Inside B class
Inside A class
```

This is the counterpart to experiment [3b](#3--classes-methods-and-constructors): overloading is
static binding, overriding is dynamic binding.

### 6 — Exception Handling

**Files:** [`6a_exception_handling.java`](6a_exception_handling.java),
[`6b_multiple_catch_clauses.java`](6b_multiple_catch_clauses.java),
[`6c_builtin_exceptions.java`](6c_builtin_exceptions.java),
[`6d_user_defined_exception.java`](6d_user_defined_exception.java) · **Input:** none

**6a — try/catch.** An integer division by zero throws `ArithmeticException`, the `catch` block
handles it, and execution resumes at the statement after the block. The final line is the whole
point: a caught exception aborts the `try` block, not the program.

```text
java.lang.ArithmeticException: / by zero
After the catch statement
```

**6b — Multiple catch clauses.** One `try` block, two handlers. The JVM matches the thrown object
against each `catch` in order and runs the first one whose parameter type is compatible. Here the
array access `d[10]` on a two-element array throws, so the `ArrayIndexOutOfBoundsException` clause
runs while the `ArithmeticException` clause is skipped. Catch clauses must be ordered
most-specific first; a `catch (Exception e)` placed before a subclass handler is a compile error.

```text
java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 2
After the catch statement
```

**6c — Built-in exceptions.** Exercises the unchecked exceptions defined in `java.lang`, all of
which descend from `RuntimeException` and therefore need no `throws` clause. Only the first of
the three is actually reached — see [Known Issues](#known-issues).

```text
java.lang.ArithmeticException: / by zero
```

**6d — User-defined exception.** `class A extends Exception` with a constructor that forwards its
message to `super(s1)`. Because it extends `Exception` rather than `RuntimeException` it is a
*checked* exception: the compiler requires it to be caught or declared. Printing the caught object
yields the class name followed by the message supplied at the `throw` site.

```text
A: demo
```

### 7 — Multithreading

**Files:** [`7a_threads.java`](7a_threads.java), [`7b_alive_join.java`](7b_alive_join.java),
[`7c_daemon_threads.java`](7c_daemon_threads.java),
[`7d_producer_consumer.java`](7d_producer_consumer.java) · **Input:** none

**7a — Three concurrent threads.** `A`, `B` and `C` each extend `Thread` and override `run()`,
printing on a 1-, 2- and 3-second cadence respectively for ten iterations. `start()` requests a
new thread of execution from the JVM and returns immediately; calling `run()` directly would
merely invoke a method on the current thread and defeat the exercise. Runs for roughly 30 seconds.

```text
good morning
hello
good morning
welcome
good morning
hello
...
```

**7b — isAlive() and join().** The same three threads, wrapped in a status check. Straight after
`start()` all three report `true`; `join()` then blocks the main thread until each worker
terminates, after which all three report `false`. `join()` is the usual choice — `isAlive()` only
samples the state at one instant, whereas `join()` waits for a definite answer.

```text
true
true
true
good morning
hello
...
false
false
false
```

**7c — Daemon threads.** `a1.setDaemon(true)` marks one of three otherwise identical threads as a
daemon; `Thread.currentThread().isDaemon()` reports which branch each thread takes. A daemon is a
background thread the JVM will not wait for: once the last user thread finishes, the JVM exits and
kills any daemon still running. `setDaemon()` must be called before `start()` or it throws
`IllegalThreadStateException`.

```text
daemon thread work
user thread work
user thread work
```

**7d — Producer–consumer.** The classic inter-thread communication problem. A shared object `A`
guards a single-slot buffer with `synchronized` methods, so only one thread holds its monitor at a
time. A boolean flag records whether the slot is full; `wait()` releases the monitor and parks the
caller when it cannot proceed, and `notify()` wakes it once the other side has changed the state.
The result is a strict alternation that neither `synchronized` alone nor a spin loop would give
you.

```text
Put:1
Got:1
Put:2
Got:2
...
Put:10
Got:10
```

### 8 — User-Defined Packages

**Files:** [`8a_user_defined/8a_user_defined.java`](8a_user_defined/8a_user_defined.java),
[`8a_user_defined/mypack1/Demo1.java`](8a_user_defined/mypack1/Demo1.java),
[`8a_user_defined/mypack1/Demo2.java`](8a_user_defined/mypack1/Demo2.java) · **Input:** none

**8a — Importing a user-defined package.** A package is Java's unit of namespacing and
visibility. `Demo1` and `Demo2` each declare `package mypack1;` on their first line, which puts
them in that namespace and requires them to live in a `mypack1/` directory. The driver then
pulls them in by name with `import mypack1.Demo1;`.

Two details make this experiment different from every other one in the record, and both are
consequences of the package declaration:

- `Demo1` and `Demo2` must be declared `public`, and so must their `display()` methods.
  Without `public` they would carry default (package-private) access and be invisible to
  `Test`, which sits outside `mypack1`. Everywhere else in this record the terse
  package-private default was sufficient, because all the classes shared one namespace.
- Because those classes are `public`, their file names are forced: `Demo1` must be in
  `Demo1.java`. The driver class `Test` is *not* `public`, so it keeps the free file naming
  used throughout the rest of the repository.

See [Compiling the Program: User-Defined Packages](#compiling-the-program-user-defined-packages)
for the commands; the program prints:

```text
welcome Demo1
welcome Demo2
```

---

## Concept Summary

| #    | Program                 | Concept                      | Key construct                               | Bound at     |
| :--- | :---------------------- | :--------------------------- | :------------------------------------------ | :----------- |
| 1a   | Primitive defaults      | Field initialisation         | `static` fields, wrapper vs. primitive      | Load time    |
| 1b   | Quadratic roots         | Control flow, `Math`         | `if`/`else if`/`else`, `Math.sqrt`          | Run time     |
| 2a   | Binary search           | Divide and conquer           | `while` over `first`/`last`/`middle`        | Run time     |
| 2b   | Bubble sort             | Comparison sort              | Nested loops with adjacent swap             | Run time     |
| 2c   | StringBuffer            | Mutable strings              | `delete`, `deleteCharAt`, `length`          | Run time     |
| 3a   | Class mechanism         | Encapsulation                | `class`, `new`, instance method             | Compile time |
| 3b   | Method overloading      | Static polymorphism          | Same name, different parameter list         | Compile time |
| 3c   | Constructor             | Object initialisation        | `A()`                                       | Run time     |
| 3d   | Constructor overloading | Static polymorphism          | `A()` and `A(int, int)`                     | Compile time |
| 4a   | Single inheritance      | Code reuse                   | `extends`, implicit `super()`               | Run time     |
| 4b   | Multilevel inheritance  | Hierarchy depth              | `A` → `B` → `C` constructor chain           | Run time     |
| 4c   | Abstract class          | Abstraction                  | `abstract class`, `abstract` method         | Compile time |
| 5a   | `super` keyword         | Parent initialisation        | `super(u, v)` as first statement            | Compile time |
| 5b   | Interface               | Multiple inheritance of type | `interface`, `implements`, `extends`        | Compile time |
| 5c   | Runtime polymorphism    | Dynamic dispatch             | Overriding via a superclass reference       | **Run time** |
| 6a   | Exception handling      | Recovery                     | `try` / `catch`                             | Run time     |
| 6b   | Multiple catch clauses  | Handler selection            | Ordered `catch` blocks, most specific first | Run time     |
| 6c   | Built-in exceptions     | Unchecked exceptions         | `RuntimeException` subclasses               | Run time     |
| 6d   | User-defined exception  | Checked exceptions           | `extends Exception`, `throw`                | Compile time |
| 7a   | Thread creation         | Concurrency                  | `extends Thread`, `start()`, `sleep()`      | Run time     |
| 7b   | isAlive() / join()      | Thread lifecycle             | `join()` blocks until termination           | Run time     |
| 7c   | Daemon threads          | Background threads           | `setDaemon(true)`, `isDaemon()`             | Run time     |
| 7d   | Producer–consumer       | Synchronisation              | `synchronized`, `wait()`, `notify()`        | Run time     |
| 8a   | User-defined package    | Namespacing and visibility   | `package`, `import`, `public`               | Compile time |

Complexity of the two algorithmic experiments, with `n` the number of elements: binary search
(`2a`) is `O(log n)` time and `O(1)` extra space; bubble sort (`2b`) is `Θ(n²)` time and `O(1)`
extra space in every case, because the implementation carries no early-exit flag.

## Known Issues

These programs produce the expected output on their intended inputs, but misbehave outside that
range or diverge from the algorithm they are named after. They are documented here rather than
silently omitted.

| File                                                              | Symptom                                                   | Cause                                                                                                                                                                        |
| :---------------------------------------------------------------- | :--------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [`4c_abstract_class_area.java`](4c_abstract_class_area.java)      | Square of side 6.5 reports an area of `26.0`, not `42.25` | `square.area()` returns `4 * s`, which is the **perimeter** formula. It should be `s * s`.                                                                                    |
| [`1b_quad_eq.java`](1b_quad_eq.java)                              | `a=4 b=4 c=1` prints `Root:0.0` instead of `-0.5`         | In the `D == 0` branch, `-b / (2 * a)` is evaluated as integer division and only then widened to `double`. Making one operand floating point — `-b / (2.0 * a)` — fixes it.   |
| [`1b_quad_eq.java`](1b_quad_eq.java)                              | `a=0` prints `NaN` and `-Infinity`                        | An `a` of zero makes the equation linear, not quadratic, and divides by `2 * a == 0`. The input is never validated.                                                          |
| [`1a_primitive.java`](1a_primitive.java)                          | The boolean line prints `null`, not `false`               | The field is declared as the wrapper `Boolean`, whose default is a null reference. The primitive `boolean` would print `false`, which is what the experiment asks for.        |
| [`6c_builtin_exceptions.java`](6c_builtin_exceptions.java)        | Only `ArithmeticException` is ever shown                  | The division by zero on the first line aborts the `try` block, so the `charAt` statements below it are unreachable. No statement in the file can throw `NullPointerException`. |
| [`6b_multiple_catch_clauses.java`](6b_multiple_catch_clauses.java) | The value of `c` is never printed                         | `System.out.println(d[10])` throws before the `println(c)` on the following line. Harmless, but the arithmetic result is silently lost.                                       |
| [`2a_binary_search.java`](2a_binary_search.java), [`2b_bubble_sort.java`](2b_bubble_sort.java) | `ArrayIndexOutOfBoundsException` for more than 20 elements | Both allocate a fixed `int[20]` and read `n` without checking it against that bound.                                          |
| [`2b_bubble_sort.java`](2b_bubble_sort.java)                      | `Θ(n²)` even on already-sorted input                      | The textbook early-exit `swapped` flag is absent, and the inner loop always runs to `n - 1` instead of shrinking to `n - i - 1`.                                              |
| [`7a_threads.java`](7a_threads.java)                              | The `Runnable` variant is missing                         | The experiment asks for the same program repeated by implementing `Runnable`; only the `extends Thread` version is present. `7d` does use `Runnable`.                          |
| [`7d_producer_consumer.java`](7d_producer_consumer.java)          | Correct only for exactly one producer and one consumer    | The guard is `if (!b) wait();` rather than `while (!b) wait();`, so a spurious wakeup or a second consumer would let a thread proceed on a stale condition.                    |
| [`1b_quad_eq.java`](1b_quad_eq.java), [`2a_binary_search.java`](2a_binary_search.java), [`2b_bubble_sort.java`](2b_bubble_sort.java) | Unhandled `InputMismatchException` on non-numeric input | `Scanner.nextInt()` is called with no `try`/`catch` and no `hasNextInt()` guard, so any non-numeric entry propagates a stack trace instead of re-prompting. |

Output ordering in experiments `7a`, `7b` and `7c` is scheduler-dependent and will differ between
runs; in `7c` the daemon thread may not print at all if the JVM exits first. That is inherent to
concurrency, not a defect.

Fixes for any of the above are welcome.

## Coding Conventions

- **Language level:** plain Java — no generics, lambdas, records or modules. Compiles under JDK 8
  and every release since.
- **Packages:** experiments 1–7 declare no package, so all their classes live in the default
  package and `-cp` alone is enough to run them. Experiment 8 is the exception and introduces
  `mypack1`.
- **Visibility:** no class is declared `public`, so file names are free to follow the lab-manual
  numbering rather than the class name.
- **Naming:** `PascalCase` for the driver classes (`OneA`, `TwoB`, …; `8a` breaks the pattern with
  `Test`) and lowercase with an experiment-number prefix for file names. Helper classes keep the
  manual's terse `A`, `B`, `C`; the shape classes in `4c` are lowercase, contrary to the usual
  Java convention.
- **Documentation:** every file opens with a one-line comment carrying the question as printed in
  the lab manual.
- **Formatting:** two-space indentation, K&R braces, one statement per line.
- **Dependencies:** JDK standard library only — no build file, no external JARs.

## Author(s)

- **Mrs. M. Manasa** — II-I B.Tech, Java Faculty.
- **Mr. Joshua Udaya Teja** — Dr C.R. Rao Laboratory Assistant (Lab: 109).

## License

Released under the [MIT License](LICENSE). These programs are lab coursework, published for
reference and study.
