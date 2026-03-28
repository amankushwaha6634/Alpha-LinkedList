public class LinkedList {

    class Node {
        int data;   // value of node
        Node next;  // points to next node


        // constructor: only data
        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    /*
    ==============================================================
    convertArrToLL(arr)
    --------------------------------------------------------------
    - Converts an array into a Singly Linked List

    Steps:
    - Create head using first array element
    - Maintain a tail pointer to last node
    - Traverse remaining array elements
    - For each element:
        • create new node
        • connect tail.next to new node
        • move tail forward

    Effect:
    arr = {2, 5, 8, 7}

    Linked List:
    [2] -> [5] -> [8] -> [7] -> null

    Time Complexity: O(n)
    Space Complexity: O(n)   // for creating n nodes

    Key Idea:
    - head always stays at first node
    - tail keeps moving to last inserted node
    ==============================================================
    */
    public Node convertArrToLL(int[] arr) {

        Node head = new Node(arr[0]); // first node
        Node tail = head;             // tail starts from head

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); // create new node

            tail.next = temp; // connect tail to new node
            tail = temp;      // move tail forward
        }

        return head;
    }

    // function to print linked list
    public void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // function to find length of linked list
    public void lengthLL(Node head) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Length = " + count);
    }
}

class Main {
    public static void main(String[] args) {

        int[] arr = {2, 5, 8, 7};

        LinkedList ll = new LinkedList();

        // call function using object
        LinkedList.Node head = ll.convertArrToLL(arr);

        // print linked list
        ll.printLL(head);

        // print length
        ll.lengthLL(head);
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

mover -> [2 | null]
temp -> [5 | null]

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
Node temp = new Node(8);

temp = [8 | null]

Current:
mover -> [5]

Now:
mover.next = temp;
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
Node temp = new Node(7);

temp = [7 | null]

Current:
mover -> [8]

Now:
mover.next = temp;
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