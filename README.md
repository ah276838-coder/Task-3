# Task 3 - UNEB Candidate Registration System

A Java project that demonstrates Object-Oriented Programming concepts including
static blocks, instance initializer blocks, and constructors.

## Project Structure

| File | Description |
|------|-------------|
| `Main.java` | Entry point - creates and displays two Student candidates |
| `Student.java` | Candidate class with instance initializer and constructor |
| `ExaminationSettings.java` | Stores global exam config using static fields and static block |

## How to Run

1. Open the project in IntelliJ IDEA
2. Navigate to `src/Main.java`
3. Click the green Run button or press `Shift + F10`

## Key OOP Concepts Used

- **Static Block** → Runs once when `ExaminationSettings` class is first loaded
- **Instance Initializer Block** → Runs before every `Student` constructor call
- **Constructor** → Sets candidate-specific data like name and school
- **Exam Year:** 2026 | **Registration Fee:** UGX 50,000
