# Ujjawal_DSA_Project


# Course Prerequisite Planner

## Project Details

- **Student ID:** RU-25-11554
- **Student Name:** Ujjwal Kumar
- **Roll Number:** 54
- **Project Number:** 54
- **Project Title:** Course Prerequisite Planner
- **Programming Language:** Java

## Project Description

The Course Prerequisite Planner is a Java-based application that helps students determine the correct order of completing courses based on their prerequisite requirements.

The project uses a directed graph to represent course dependencies. It applies Depth First Search (DFS), Breadth First Search (BFS), Stack, and Sorting algorithms to generate a valid course completion sequence.

The application also detects cycles in the graph. If a cycle exists, it informs the user that a valid course order cannot be generated.

## Objectives

- Represent courses and prerequisites using a directed graph.
- Find a valid course completion order.
- Implement DFS and BFS traversal algorithms.
- Use a stack for DFS-based topological sorting.
- Apply alphabetical sorting to course names.
- Detect cycles in course dependencies.

## Technologies Used

- Java
- Java Collections Framework
- HashMap
- ArrayList
- Queue
- Stack (Deque)
- Graph Algorithms

## Data Structures and Algorithms

### 1. Graph
A directed graph represents courses and their prerequisite relationships.

### 2. Depth First Search (DFS)
DFS traverses the graph and helps generate a topological ordering of courses.

### 3. Breadth First Search (BFS)
BFS uses Kahn's algorithm to generate a valid course completion order.

### 4. Stack
A stack stores courses after their dependencies have been processed during DFS.

### 5. Sorting
Courses are displayed in alphabetical order using Java's Collections.sort() method.

### 6. Cycle Detection
The program detects circular prerequisite relationships and prevents invalid course scheduling.

## How to Run the Project

### Step 1: Install Java
Install JDK on your computer.

### Step 2: Create the Java File
Create a file named:

CoursePrerequisitePlanner.java

### Step 3: Compile the Program

```bash
javac CoursePrerequisitePlanner.java
```

### Step 4: Run the Program

```bash
java CoursePrerequisitePlanner
```

## Sample Input

```text
5
Programming
Data Structures
Algorithms
Artificial Intelligence
Database
4
Programming
Data Structures
Data Structures
Algorithms
Algorithms
Artificial Intelligence
Programming
Database
```

## Sample Output

```text
COURSE PREREQUISITE PLANNER

Courses in alphabetical order:
Algorithms
Artificial Intelligence
Data Structures
Database
Programming

Course order using DFS:
Programming
Database
Data Structures
Algorithms
Artificial Intelligence

Course order using BFS:
Programming
Data Structures
Database
Algorithms
Artificial Intelligence
```

Note: The course order may vary because multiple valid topological orders can exist.

## Time Complexity

| Algorithm | Time Complexity |
|---|---|
| Add Course | O(1) |
| DFS Topological Sort | O(V + E) |
| BFS Topological Sort | O(V + E) |
| Alphabetical Sorting | O(V log V) |

Where:

- V = Number of courses
- E = Number of prerequisite relationships

## Applications

- University course planning
- Academic prerequisite management
- Study schedule preparation
- Subject dependency management
- Educational planning systems

## Conclusion

The Course Prerequisite Planner demonstrates the practical application of graph data structures and graph algorithms in Java.

It helps students understand course dependencies, determine a valid course completion sequence, and identify circular prerequisites.

This project provides a simple and effective solution for academic course planning using DFS, BFS, Stack, Sorting, and Cycle Detection.

