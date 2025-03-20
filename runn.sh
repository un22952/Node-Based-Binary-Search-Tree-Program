#!/bin/bash -x

javac -d bin src/NodeType.java
javac -d bin -cp bin src/BinarySearchTree.java
javac -d bin -cp bin src/BinarySearchTreeDriver.java

java -cp bin BinarySearchTreeDriver src/double-input.txt
