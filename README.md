# Node-Based Binary Search Tree Program

This project implements a **generic, node-based Binary Search Tree (BST)** in Java. The program supports multiple data types, including integers, doubles, and strings, and provides a command-line interface for interacting with the tree.

Users can insert, delete, and search for values, print the tree using an in-order traversal, count leaf nodes, find single-parent nodes, and find the cousins of a specified node.

The tree is implemented using Java generics with the constraint:

```java
T extends Comparable<T>
```

This allows the same Binary Search Tree implementation to work with different comparable data types.

## Overview

The program reads an initial set of values from an input file and inserts them into a Binary Search Tree.

When the program starts, the user selects the tree's data type:

```text
Enter tree type (i - int, d - double, s std:string):
```

The available choices are:

```text
i → Integer
d → Double
s → String
```

After the tree is created, the program provides an interactive command menu.

## Features

The program supports:

* Generic Binary Search Tree implementation
* Integer values
* Double values
* String values
* Recursive insertion
* Searching
* Node deletion
* In-order traversal
* Leaf-node counting
* Single-parent detection
* Cousin-node detection
* Duplicate-value detection
* Command-line input
* File-based initial data
* Java generics and `Comparable<T>`

## Project Structure

```text
.
├── src/
│   ├── NodeType.java
│   ├── BinarySearchTree.java
│   ├── BinarySearchTreeDriver.java
│   └── int-input.txt
│
└── run.sh
```

### `NodeType.java`

Defines the individual nodes used by the Binary Search Tree.

Each node stores a value and references to its left and right children.

### `BinarySearchTree.java`

Contains the main Binary Search Tree implementation.

The class is generic:

```java
public class BinarySearchTree<T extends Comparable<T>>
```

The tree maintains a reference to its root node and implements the primary BST operations, including insertion, searching, deletion, traversal, leaf counting, single-parent detection, and cousin detection.

### `BinarySearchTreeDriver.java`

Provides the program's user interface.

It:

1. Reads the input file.
2. Asks the user to select the data type.
3. Creates the appropriate generic BST.
4. Inserts the input values.
5. Displays the command menu.
6. Executes the requested BST operation.

### `int-input.txt`

Contains the initial values used to construct the tree.

The driver reads the first line of the input file and separates the values using whitespace.

### `run.sh`

Compiles the Java source files into the `bin` directory and then launches the program.

## Requirements

You need:

* Java Development Kit (JDK)
* A terminal or command-line environment
* An input file containing the initial tree values

Verify Java is installed:

```bash
java --version
javac --version
```

## Compiling and Running

The provided script performs the compilation and execution automatically.

Make the script executable if necessary:

```bash
chmod +x run.sh
```

Then run:

```bash
./run.sh
```

The script performs:

```bash
javac -d bin src/NodeType.java
javac -d bin -cp bin src/BinarySearchTree.java
javac -d bin -cp bin src/BinarySearchTreeDriver.java

java -cp bin BinarySearchTreeDriver src/int-input.txt
```

The `-d bin` option places the compiled `.class` files into the `bin` directory.

## Choosing the Tree Type

When the program starts, it asks:

```text
Enter tree type (i - int, d - double, s std:string):
```

### Integer Tree

Enter:

```text
i
```

The program creates:

```java
BinarySearchTree<Integer>
```

### Double Tree

Enter:

```text
d
```

The program creates:

```java
BinarySearchTree<Double>
```

### String Tree

Enter:

```text
s
```

The program creates:

```java
BinarySearchTree<String>
```

This generic design allows one BST implementation to operate on different types.

## Binary Search Tree Structure

A Binary Search Tree maintains the following ordering:

```text
             Root
            /    \
      smaller    larger
```

For every node:

```text
left subtree  <  node  <  right subtree
```

For example, inserting:

```text
50 30 70 20 40 60 80
```

produces a tree conceptually like:

```text
              50
            /    \
          30      70
         /  \    /  \
       20   40  60   80
```

The actual tree structure depends on the order in which values are inserted.

## Insertion

Insertion is performed with:

```java
public void insert(T key)
```

The public method calls the recursive insertion method:

```java
root = loopp(root, key);
```

If the current node is `null`, a new node is created and initialized with the value.

The algorithm then compares the new value with the current node:

```text
key < current node
       ↓
    go left

key > current node
       ↓
    go right
```

The implementation uses `compareTo()` to perform these comparisons.

### Duplicate Values

Duplicate values are not inserted.

The program prints:

```text
Cannot insert duplicate item!
```

when a duplicate value is encountered.

## Searching

The search operation is selected with:

```text
s
```

The program asks for a value and searches the BST using the tree's ordering.

The recursive search method compares the requested value against the current node and moves either left or right. If the value is found, the program prints:

```text
The item is present in the tree!
```

If the search reaches a null node, it prints:

```text
The item is not in the tree!
```

These messages are implemented in the search routine.

## In-Order Traversal

The print operation is selected with:

```text
p
```

The tree is printed using an **in-order traversal**.

The traversal follows:

```text
Left
 ↓
Root
 ↓
Right
```

The recursive implementation follows this exact order.

For a valid BST, an in-order traversal prints the values in sorted order.

For example:

```text
       50
      /  \
    30    70
```

produces:

```text
30 50 70
```

The program labels the output:

```text
In Order:
```

## Deletion

The delete operation is selected with:

```text
d
```

The program searches for the specified node and removes it while attempting to preserve the BST structure.

The deletion implementation handles the root separately and determines the appropriate replacement node when removing a node.

The implementation searches for a replacement by examining the target's left subtree and moving toward the largest value on that side.

After the deletion, the program prints:

```text
After deletion:
```

followed by the tree's in-order traversal.

## Leaf Nodes

A **leaf node** is a node that has:

```text
left == null
right == null
```

The program can count leaf nodes using:

```text
l
```

The recursive `getLeaf()` method checks every node and increments `leafCount` when both child references are null.

The result is displayed as:

```text
The number of leaves in the tree is X
```

## Single Parents

The command:

```text
sp
```

finds nodes that have a single child.

The program identifies a node as a single parent when it has exactly one child and that child is a leaf node. The relevant conditions are implemented inside `getLeaf()`.

The output begins with:

```text
The single parents:
```

## Cousins

The command:

```text
c
```

finds the cousins associated with a specified node.

Two nodes are considered cousins when they are at the same level but have different parents.

The implementation first obtains the parent of the requested item and then obtains the grandparent to locate the item's uncle or aunt and their children.

The output begins with:

```text
The cousins:
```

## Command Menu

After the tree is created, the program provides the following commands:

```text
(i)  - Insert Item
(d)  - Delete Item
(p)  - Print Tree
(s)  - Search Item
(l)  - Count Leaf Nodes
(sp) - Find Single Parents
(c)  - Find Cousins
(q)  - Quit program
```

| Command | Operation                |
| ------- | ------------------------ |
| `i`     | Insert a value           |
| `d`     | Delete a value           |
| `p`     | Print the tree in order  |
| `s`     | Search for a value       |
| `l`     | Count leaf nodes         |
| `sp`    | Find single-parent nodes |
| `c`     | Find cousins             |
| `q`     | Quit                     |

## Example Workflow

A typical program session can follow this structure:

```text
Enter tree type (i - int, d - double, s std:string):
i

Commands:
(i)  - Insert Item
(d)  - Delete Item
(p)  - Print Tree
(s)  - Search Item
(l)  - Count Leaf Nodes
(sp) - Find Single Parents
(c)  - Find Cousins
(q)  - Quit program

Enter a command:
p
```

The tree is then displayed using an in-order traversal.

For example:

```text
In Order: 10 20 30 40 50 60 70
```

## Generic Data Types

One of the main features of this project is its use of Java generics.

The BST is declared as:

```java
BinarySearchTree<T extends Comparable<T>>
```

This means the values stored in the tree must implement `Comparable<T>` so that the tree can determine their relative ordering.

The driver creates different versions of the same tree:

```java
BinarySearchTree<Integer>
BinarySearchTree<Double>
BinarySearchTree<String>
```

This allows the same BST algorithms to work with multiple data types.

## File Input

The driver receives the input filename through the command line:

```java
new FileReader(args[0])
```

For the provided script, the input file is:

```text
src/int-input.txt
```

The first line is split into individual values and then inserted into the tree.

## Key Concepts Demonstrated

This project demonstrates:

* Binary Search Trees
* Node-based data structures
* Java generics
* `Comparable<T>`
* Recursion
* Tree traversal
* Binary search tree insertion
* Binary search tree deletion
* Tree searching
* Leaf-node counting
* Parent/child relationships
* Cousin relationships
* File input
* Command-line arguments
* Interactive menus
* Java compilation and classpaths

## Complexity

The primary BST operations depend on the height of the tree.

For a relatively balanced tree, the height is approximately:

```text
O(log n)
```

so operations such as searching and insertion can take approximately:

```text
O(log n)
```

In a highly unbalanced tree, the height can become:

```text
O(n)
```

The provided implementation uses recursive traversal for insertion and searching, while deletion and relationship operations also traverse the tree as needed.

## Quick Start

Compile and run the project:

```bash
./run.sh
```

Or manually:

```bash
javac -d bin src/NodeType.java
javac -d bin -cp bin src/BinarySearchTree.java
javac -d bin -cp bin src/BinarySearchTreeDriver.java

java -cp bin BinarySearchTreeDriver src/int-input.txt
```

Then select the desired tree type and use the interactive commands to manipulate and analyze the Binary Search Tree.

## Summary

This project implements a **generic, node-based Binary Search Tree in Java**. It supports integer, double, and string data and provides an interactive interface for performing common BST operations.

The project combines fundamental data-structure concepts—including **nodes, recursion, tree traversal, searching, insertion, deletion, parent-child relationships, and tree properties**—with Java features such as **generics, `Comparable<T>`, file input, and command-line execution**.
