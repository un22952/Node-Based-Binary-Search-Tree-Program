# Node-Based Binary Search Tree

## Description
A generic Java Binary Search Tree (BST) supporting integers, doubles, and strings. Supports insertion, deletion, searching, in-order traversal, leaf counting, single-parent detection, and finding cousins. Reads initial values from a text file and provides an interactive command-line menu.

## Run

```bash
chmod +x run.sh
./run.sh
```

The program loads values from `src/int-input.txt` and asks you to select a data type:

- `i` — Integer
- `d` — Double
- `s` — String

## Commands

| Command | Operation |
|---|---|
| `i` | Insert a value |
| `d` | Delete a value |
| `p` | Print values in sorted order |
| `s` | Search for a value |
| `l` | Count leaf nodes |
| `sp` | Find single-parent nodes |
| `c` | Find cousins |
| `q` | Quit |

## Requirements
- Java Development Kit (JDK)
- Initial values in `src/int-input.txt`
