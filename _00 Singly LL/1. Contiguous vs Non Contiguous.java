/*
==============================================================
DIAGRAMS TO UNDERSTAND ARRAY vs LINKED LIST
==============================================================

1) ARRAY DIAGRAM
--------------------------------------------------------------
Array elements are stored in contiguous memory
means one after another in memory.

Index:      0        1        2
           +---+    +---+    +---+
Value:     | 0 |    | 1 |    | 2 |
           +---+    +---+    +---+

Address:   1000     1004     1008

So memory looks like:
[0][1][2]

Meaning:
- all elements are continuous
- next element is just next memory block

--------------------------------------------------------------

2) LINKED LIST DIAGRAM
--------------------------------------------------------------
Linked list nodes are NOT stored continuously.

head
 |
 v
+------+    +------+    +------+
|  0   | -> |  1   | -> |  2   | -> null
+------+    +------+    +------+

But actual memory may be:

Node 0 at address 5000
Node 1 at address 9000
Node 2 at address 3000

So actual storage is scattered:
[5000] -> [9000] -> [3000]

Meaning:
- nodes are at random places
- connection happens using next pointer

--------------------------------------------------------------

3) INTERNAL NODE STRUCTURE OF LINKED LIST
--------------------------------------------------------------
Each node has 2 parts:

+---------+---------+
|  data   |  next   |
+---------+---------+

Example:

+---------+---------+
|   10    |  8000   |
+---------+---------+

This means:
- data = 10
- next = address of next node = 8000

--------------------------------------------------------------

4) LINKED LIST FULL MEMORY VIEW
--------------------------------------------------------------
head
 |
 v
+---------+---------+      +---------+---------+      +---------+---------+
|   10    |  8000   | ---> |   20    |  3000   | ---> |   30    |  null  |
+---------+---------+      +---------+---------+      +---------+---------+

Actual addresses:
Node(10) stored at 5000
Node(20) stored at 8000
Node(30) stored at 3000

So:
head = 5000

At address 5000:
+---------+---------+
|   10    |  8000   |
+---------+---------+

At address 8000:
+---------+---------+
|   20    |  3000   |
+---------+---------+

At address 3000:
+---------+---------+
|   30    |  null   |
+---------+---------+

--------------------------------------------------------------

5) WHY ARRAY HAS FAST ACCESS
--------------------------------------------------------------
Array:

Index:      0        1        2        3
           +---+    +---+    +---+    +---+
Value:     | 5 |    | 7 |    | 9 |    | 2 |
           +---+    +---+    +---+    +---+

Suppose base address = 1000
Each int takes 4 bytes

Address of arr[0] = 1000
Address of arr[1] = 1004
Address of arr[2] = 1008
Address of arr[3] = 1012

Formula:
address of arr[i] = base + (i * size)

So array can directly jump to any index.

--------------------------------------------------------------

6) WHY LINKED LIST HAS SLOW ACCESS
--------------------------------------------------------------
Linked List:

head
 |
 v
+------+    +------+    +------+    +------+
|  5   | -> |  7   | -> |  9   | -> |  2   | -> null
+------+    +------+    +------+    +------+

To reach value 9:
- first go to 5
- then 7
- then 9

We cannot directly jump like arr[2].

--------------------------------------------------------------

7) INSERTION IDEA DIAGRAM
--------------------------------------------------------------
Insert 99 at beginning:

Before:
head
 |
 v
+------+    +------+    +------+
|  10  | -> |  20  | -> |  30  | -> null
+------+    +------+    +------+

Create new node:
+------+
|  99  |
+------+

After:
head
 |
 v
+------+    +------+    +------+    +------+
|  99  | -> |  10  | -> |  20  | -> |  30  | -> null
+------+    +------+    +------+    +------+

--------------------------------------------------------------

8) DELETION IDEA DIAGRAM
--------------------------------------------------------------
Delete node 20

Before:
head
 |
 v
+------+    +------+    +------+
|  10  | -> |  20  | -> |  30  | -> null
+------+    +------+    +------+

Change link of 10 directly to 30

After:
head
 |
 v
+------+    +------+
|  10  | -> |  30  | -> null
+------+    +------+

--------------------------------------------------------------

9) BEST ONE-LINE VISUAL UNDERSTANDING
--------------------------------------------------------------
Array:
[10][20][30][40]
continuous memory

Linked List:
[10|*] -> [20|*] -> [30|*] -> [40|null]
scattered memory, connected by pointers

==============================================================
*/