David G C
C0913647

Overview

This project contains implementations of several data structures that simulate managing artifacts, explorers, clues, and paths. The challenges involved using arrays, stacks, queues, linked lists, and binary trees to solve different problems. Each structure is built as a separate class with specific operations.

Challenges Breakdown

1. The Array Artifact (20 points)


Approach:
The ArtifactVault uses an array to store artifacts and keeps it sorted by artifact age for efficient binary search. Linear search is used for unsorted searches and removal, while binary search is used for optimized retrieval. 

---

2. The Linked List Labyrinth (20 points)


Approach:
The LabyrinthPath class is implemented using a singly linked list. A loop detection algorithm (Floyd’s cycle-finding algorithm) is used to check for traps in the path. Locations are stored as nodes in the linked list, and each node points to the next location.

---

3. The Stack of Ancient Texts (20 points)

Approach:
The ScrollStack is implemented using a stack, following the last-in-first-out (LIFO) principle. Operations are efficiently handled using an internal list structure for managing scrolls.

---

4. The Queue of Explorers (20 points)

Approach:
The ExplorerQueue is implemented using a circular array to manage explorers efficiently. The circular queue reuses empty slots once explorers exit, ensuring optimized space usage.

---

5. The Binary Tree of Clues (20 points)

Approach:
The ClueTree is implemented as a BST to allow efficient insertions and searches. Recursive methods are used for traversals and counting the number of clues. The tree automatically maintains order as new clues are inserted.

---

Assumptions and Design Decisions
1) ArtifactVault: Assumed that the artifacts can be managed in a fixed-sized array, and binary search is only applicable after sorting the array by artifact age.
2) LabyrinthPath: Assumed that the path can grow dynamically, and cycle detection was implemented using Floyd’s algorithm to find traps.
3) ScrollStack: Assumed the stack size is dynamic and scrolls can be added or removed at any time.
4) ExplorerQueue: Assumed that the queue has a fixed capacity and operates in a circular manner to efficiently use space.
5) ClueTree: Assumed that the tree operates as a binary search tree, ensuring efficient insertion and retrieval.

---

How to Run the Code

Prerequisites:
- Java Development Kit (JDK) 8 or higher installed.

 Steps:
1. Clone or download the repository.
2. Navigate to the folder containing the source files.
3. Compile the code using:
   ```bash
   javac Main.java ArtifactVault.java LabyrinthPath.java ScrollStack.java ExplorerQueue.java ClueTree.java
