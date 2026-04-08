class CustomLL {
    Node head; // Head of the linked list

    // Definition of a Node in the linked list
    class Node {
        int data;      // Data stored in the node
        Node next;     // Pointer to the next node

        // Constructor to initialize a node
        public Node(int data1) {
            this.data = data1;  // Set the data
            this.next = null;   // Initialize next as null
        }
    }

    // Method to add a node with the given data at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head
            return;
        }
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node
            currNode = currNode.next;
        }
        currNode.next = newNode; // Attach the new node at the end
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) { // Traverse and print each node
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // End of the list
    }

    /*
    Segregating odd and even position nodes in-place:

        Idea:
        - Maintain two separate chains:
            1. Odd-position nodes
            2. Even-position nodes

        - Traverse linked list once
        - Reconnect odd nodes together
        - Reconnect even nodes together
        - Finally attach even list after odd list

        Example:
            Original:
            1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7

            Odd Position Nodes:
            1 -> 3 -> 5 -> 7

            Even Position Nodes:
            2 -> 4 -> 6

            Final List:
            1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6
    */
    public void segregateOddEvenIndices() {

        // No need to rearrange if list has 0 or 1 node
        if (head == null || head.next == null) {
            return;
        }

        // odd points to first node
        Node odd = head;

        // even points to second node
        Node even = head.next;

        // Save starting point of even list
        Node evenHeadForFuture = head.next;

        /*
            Traverse while:
            - even exists
            - and next node after even exists

            Why?
            - Because we need:
                  odd.next.next
                  even.next.next
        */
        while (even != null && even.next != null) {

            // Connect odd node to next odd node
            odd.next = odd.next.next;

            // Move odd pointer forward
            odd = odd.next;

            // Connect even node to next even node
            even.next = even.next.next;

            // Move even pointer forward
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHeadForFuture;
    }
}

/*
    Initial State:

        odd = 1
        even = 2
        evenHead = 2

        1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7

    ----------------------------------------------------------

    Loop Condition:

        while (even != null && even.next != null)

    Meaning:
    - Continue only if current even node exists
    - And there is another node after even

    Why?
    - Because we need:
            odd.next.next
            even.next.next

    Otherwise NullPointerException may happen
*/
public class Optimal {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        System.out.println("Original List:");
        list.printList();

        // Segregate odd and even indexed nodes
        list.segregateOddEvenIndices();

        // Print the modified list
        System.out.println("After Segregating Odd and Even Indexed Nodes:");
        list.printList();
    }
}

/*
    Dry Run:
    ------------------------------------------------

    Original List:
    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null

    Initially:
        odd = 1
        even = 2
        evenHead = 2

    ------------------------------------------------
    Iteration 1:

    odd.next = odd.next.next

        1 -> 2 -> 3

    Connect:
        1 -> 3

    List now:
        Odd side:
        1 -> 3 -> 4 -> 5 -> 6 -> 7

    Move odd:
        odd = 3

    --------------------------------

    even.next = even.next.next

        2 -> 3 -> 4

    Connect:
        2 -> 4

    List now:
        Even side:
        2 -> 4 -> 5 -> 6 -> 7

    Move even:
        even = 4

    ------------------------------------------------
    Iteration 2:

    odd.next = odd.next.next

        3 -> 4 -> 5

    Connect:
        3 -> 5

    Odd side becomes:
        1 -> 3 -> 5 -> 6 -> 7

    Move odd:
        odd = 5

    --------------------------------

    even.next = even.next.next

        4 -> 5 -> 6

    Connect:
        4 -> 6

    Even side becomes:
        2 -> 4 -> 6 -> 7

    Move even:
        even = 6

    ------------------------------------------------
    Iteration 3:

    odd.next = odd.next.next

        5 -> 6 -> 7

    Connect:
        5 -> 7

    Odd side becomes:
        1 -> 3 -> 5 -> 7

    Move odd:
        odd = 7

    --------------------------------

    even.next = even.next.next

        6 -> 7 -> null

    Connect:
        6 -> null

    Even side becomes:
        2 -> 4 -> 6

    Move even:
        even = null

    ------------------------------------------------
    Loop Stops

    Because:
        even == null

    ------------------------------------------------
    Current Situation:

    Odd List:
        1 -> 3 -> 5 -> 7

    Even List:
        2 -> 4 -> 6

    ------------------------------------------------
    Final Connection:

    odd.next = evenHead

        7 -> 2

    Final Linked List:
        1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6 -> null
*/