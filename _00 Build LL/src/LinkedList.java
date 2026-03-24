class Node {
    int data;   // value of node
    Node next;  // points to next node

    // constructor: data + next
    public Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    // constructor: only data
    public Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LinkedList {

    // function to convert array into linked list
    public static Node convertArrToLL(int[] arr) {
        // create head node using first array element
        Node head = new Node(arr[0]);

        // mover is used to build the list further
        Node mover = head;

        // start from index 1 because index 0 already used for head
        for (int i = 1; i < arr.length; i++) {
            // create new node for current array value
            Node temp = new Node(arr[i]);

            // connect current last node to new node
            mover.next = temp;

            // move mover to newly added node
            mover = temp;
        }

        // return head of linked list
        return head;
    }

    // function to print linked list
    public static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};

        // convert array into linked list
        Node head = convertArrToLL(arr);

        // print linked list
        printLL(head);
    }
}

/*
==============================================================
DRY RUN : CONVERT ARRAY TO LINKED LIST
==============================================================

Code:
Node head = new Node(arr[0]);
Node mover = head;

for (int i = 1; i < arr.length; i++) {
    Node temp = new Node(arr[i]);
    mover.next = temp;
    mover = temp;
}

==============================================================
INPUT
==============================================================
arr = {2, 5, 8, 7}

==============================================================
STEP 1: CREATE HEAD NODE
==============================================================
Node head = new Node(arr[0]);

arr[0] = 2

So:
head = [2 | null]

List:
head
 |
 v
[2 | null]

==============================================================
STEP 2: CREATE MOVER
==============================================================
Node mover = head;

Now:
mover is also pointing to same node as head

head
 |
 v
[2 | null]
 ^
 |
mover

==============================================================
STEP 3: LOOP STARTS
==============================================================

-------------------------
i = 1
-------------------------
arr[1] = 5

Node temp = new Node(5);

temp = [5 | null]

Current:
head -> [2 | null]
temp -> [5 | null]
mover -> [2 | null]

Now:
mover.next = temp;

So node 2 will point to node 5

List becomes:
[2 | * ] -> [5 | null]

Now:
mover = temp;

So mover shifts to node 5

head
 |
 v
[2 | * ] -> [5 | null]
             ^
             |
           mover

==============================================================

-------------------------
i = 2
-------------------------
arr[2] = 8

Node temp = new Node(8);

temp = [8 | null]

Current:
head -> [2] -> [5]
mover -> [5]
temp -> [8]

Now:
mover.next = temp;

So node 5 points to node 8

List becomes:
[2 | *] -> [5 | *] -> [8 | null]

Now:
mover = temp;

So mover shifts to node 8

head
 |
 v
[2 | *] -> [5 | *] -> [8 | null]
                        ^
                        |
                      mover

==============================================================

-------------------------
i = 3
-------------------------
arr[3] = 7

Node temp = new Node(7);

temp = [7 | null]

Current:
head -> [2] -> [5] -> [8]
mover -> [8]
temp -> [7]

Now:
mover.next = temp;

So node 8 points to node 7

List becomes:
[2 | *] -> [5 | *] -> [8 | *] -> [7 | null]

Now:
mover = temp;

So mover shifts to node 7

head
 |
 v
[2 | *] -> [5 | *] -> [8 | *] -> [7 | null]
                                     ^
                                     |
                                   mover

==============================================================
LOOP ENDS
==============================================================
Now all array elements are converted into linked list.

Final head:
head
 |
 v
[2] -> [5] -> [8] -> [7] -> null

==============================================================
FINAL OUTPUT
==============================================================
2 -> 5 -> 8 -> 7 -> null

==============================================================
IMPORTANT IDEA
==============================================================
- head always stays at first node
- mover keeps moving to the last created node
- temp creates the new node every iteration
- mover.next = temp connects the new node
- mover = temp moves forward for next insertion
==============================================================
*/