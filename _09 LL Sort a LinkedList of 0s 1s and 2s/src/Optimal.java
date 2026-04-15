class CustomL {
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
        Node newNode = new Node(data); // Create a new node with the provided data
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head of the list
            return;
        }
        Node currNode = head;
        // Traverse to the last node in the list
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode; // Attach the new node at the end of the list
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        // Traverse and print each node's data until reaching the end of the list
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null"); // Print null at the end to signify the end of the list
    }

    // Method to sort the linked list containing 0's, 1's, and 2's using three dummy nodes
    public void sortList() {
        // Create dummy nodes for 0's, 1's, and 2's. All initialized with value -1.
        Node zeroHead = new Node(-1);  // Dummy node for 0's
        Node oneHead = new Node(-1);   // Dummy node for 1's
        Node twoHead = new Node(-1);   // Dummy node for 2's

        // Step 1: Use the dummy nodes to keep track of the last node in each list
        Node zeroTail = zeroHead;  // Pointer for the last node in the 0's list
        Node oneTail = oneHead;    // Pointer for the last node in the 1's list
        Node twoTail = twoHead;    // Pointer for the last node in the 2's list

        // Step 2: Traverse the original list and distribute nodes to the corresponding lists
        Node current = head; // Start with the head of the original list
        while (current != null) {
            // Depending on the value of the current node, append it to the appropriate list
            if (current.data == 0) {
                zeroTail.next = current;  // Attach the current node to the 0's list
                zeroTail = zeroTail.next; // Move the zeroTail pointer to the current node
            } else if (current.data == 1) {
                oneTail.next = current;   // Attach the current node to the 1's list
                oneTail = oneTail.next;   // Move the oneTail pointer to the current node
            } else if (current.data == 2) {
                twoTail.next = current;   // Attach the current node to the 2's list
                twoTail = twoTail.next;   // Move the twoTail pointer to the current node
            }
            current = current.next; // Move to the next node in the original list
        }

        // Step 3: Now, connect the three lists:
        // The zeroTail should point to the 1's list, and the oneTail should point to the 2's list.
        zeroTail.next = oneHead.next!=null ? oneHead.next : twoHead.next; // Connect the 0's list to the 1's list
        // if twoHead.next is also null than also no issue. end

        oneTail.next = twoHead.next;  // Connect the 1's list to the 2's list
        twoTail.next = null;          // The last node of the 2's list should point to null

        // Step 4: Set the head to the first node of the 0's list (i.e., zeroHead.next).
        // This effectively combines the three lists (0's -> 1's -> 2's).
        head = zeroHead.next;
    }
}

// Main class to test the Custom Linked List class and its methods
public class Optimal {
    public static void main(String[] args) {
        // Create the linked list
        CustomL list = new CustomL();

        // Adding sample nodes (0's, 1's, and 2's) to the linked list
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.addLast(2);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Sort the linked list using the sortList method
        list.sortList();

        // Print the sorted list
        System.out.println("Sorted List:");
        list.printList();
    }
}


/**
Why does the linked list not break during the process?

Because while traversing, we never immediately remove or nullify
current.next.

Example:

    1 -> 0 -> 2 -> 1 -> 0 -> 2

Suppose current is at first node 1.

We do:

    oneTail.next = current
    oneTail = oneTail.next

But this node still has its original next pointer:

    1 -> 0 -> 2 -> ...

So traversal can still continue safely using:

    current = current.next

We only use the node as part of a new chain,
but we do NOT cut its old link immediately.

Same for 0-list and 2-list.

Only after the entire traversal is finished, we reconnect:

    zeroTail.next = oneHead.next
    oneTail.next  = twoHead.next
    twoTail.next  = null

At that time, old next pointers get overwritten.

Therefore list does not break because:

1. current.next remains unchanged during traversal
2. Traversal uses original links safely
3. Final links are changed only after all nodes are processed
*/