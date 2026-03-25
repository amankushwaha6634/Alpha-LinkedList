class Node {
    int data;   // value stored in node
    Node prev;  // pointer to previous node
    Node next;  // pointer to next node

    Node(int data) {
        this.data = data;   // assign value to node
        this.prev = null;   // initially no previous node
        this.next = null;   // initially no next node
    }
}

public class DoublyLL {

    // Function to convert array → Doubly Linked List
    public static Node convertArrToDLL(int[] arr) {

        // Step 1: create head node using first element
        Node head = new Node(arr[0]);   // head = 2 (example)

        // prev pointer will help us connect nodes
        Node prev = head;               // prev = 2

        // Step 2: iterate from index 1 to end
        for (int i = 1; i < arr.length; i++) {

            // Create new node for current element
            Node temp = new Node(arr[i]); // temp = 5, then 8, then 7

            // Connect previous node → current node (forward link)
            prev.next = temp;           // 2 -> 5

            // Connect current node → previous node (backward link)
            temp.prev = prev;           // 5 <- 2

            // Move prev to current node for next iteration
            prev = temp;                // prev = 5, then 8, then 7
        }

        // Return head of the doubly linked list
        return head;
    }

    // Function to print doubly linked list (forward direction)
    public static void printDLL(Node head) {

        // Start from head
        Node temp = head;

        // Traverse till end
        while (temp != null) {

            // Print current node value
            System.out.print(temp.data + " <-> ");

            // Move to next node
            temp = temp.next;
        }

        // Print end of list
        System.out.println("null");
    }

    // 🔥 Length function
    public static int length(Node head) {

        int count = 0;        // initialize count = 0
        Node temp = head;     // start from head

        while (temp != null) {
            count++;          // increment for each node
            temp = temp.next; // move forward
        }

        return count;         // total nodes
    }
    public static void main(String[] args) {

        // Example input array
        int[] arr = {2, 5, 8, 7};
        // index:     0  1  2  3

        // Convert array to doubly linked list
        Node head = convertArrToDLL(arr);

        // Print the doubly linked list
        printDLL(head);

        int len = length(head); // get length

        System.out.println("Length = " + len);
    }
}

/*
==================== DRY RUN ====================

arr = {2, 5, 8, 7}

Step 1:
head = 2
prev = 2

List:
2

--------------------------------

i = 1 → value = 5
temp = 5

prev.next = temp → 2 -> 5
temp.prev = prev → 5 <- 2

prev = 5

List:
2 <-> 5

--------------------------------

i = 2 → value = 8
temp = 8

5 -> 8
8 <- 5

prev = 8

List:
2 <-> 5 <-> 8

--------------------------------

i = 3 → value = 7
temp = 7

8 -> 7
7 <- 8

prev = 7

Final List:
2 <-> 5 <-> 8 <-> 7 <-> null

================================================

KEY IDEA:
- Always connect BOTH directions:
    prev.next = temp
    temp.prev = prev
*/