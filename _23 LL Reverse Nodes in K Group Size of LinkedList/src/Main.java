class CustomLL5 {
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

    // Function to reverse a linked list using a 3-pointer approach
    public Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;

        // Reverse the linked list
        while (temp != null) {
            Node front = temp.next; // Save the next node
            temp.next = prev;       // Reverse the link
            prev = temp;            // Move the prev pointer forward
            temp = front;           // Move the temp pointer forward
        }
        return prev; // New head of the reversed list
    }

    // Function to get the Kth node from a given position in the linked list
    static Node getKthNode(Node node, int k) {
        int count = 0; // Initialize the count to 1
        while (node != null) {
            count++; // Increment the count
            if(count == k){
                break; // break pointer at kth node.
            }
            node = node.next; // Move to the next node

        }
        return node; // Return the Kth node or null if not found
    }

    // Function to reverse nodes in groups of K
    public void kReverse(int k) {
        Node temp = head;      // Pointer to traverse the list
        Node lastNodeOfPreviousGroup = null;  // Pointer to keep track of the previous group's last node

        while (temp != null) {
            // CASE 1: Find the Kth node in the current group
            Node kThNode = getKthNode(temp, k);

            // Termination condition :
            // CASE 2: If there are fewer than K nodes left, append them as is
            // getKthNode return null if there is no kth node
            if (kThNode == null) {

                if (lastNodeOfPreviousGroup != null) {
                    lastNodeOfPreviousGroup.next = temp; // Attach the remaining part to the previous group's end
                }
                break; // No more groups to process
            }

            // CASE 3: Reverse the current group
            // actually if we want to reverse 3 nodes list than 3rd node must point to null
            Node firstNodeOfNextGroup = kThNode.next;
            // preserve the next group's starting node before detaching
            kThNode.next = null;
            // Detach the current group
            Node newHead = reverseLinkedList(temp);

            // CASE 4: First Head
            // If this is the first group, update the head of the entire list
            if (temp == head) {
                head = newHead;
            } else {
                // CASE 5: Attach the reversed group to the previous group's last node
                lastNodeOfPreviousGroup.next = newHead;
            }

            // CASE 6: Update pointers for the next iteration
            lastNodeOfPreviousGroup = temp; // The current group's first node becomes the last after reversal
            // before jumping temp from current node to 'firstNodeOfNextGroup'
            // preserve 'lastNodeOfPreviousGroup' for future linking
            // basically currently its ""last Node Of current Group""

            temp = firstNodeOfNextGroup; // Move to the next group
        }
    }
}

// getKthNode(): 0(N) -    Traversing the complete list to find the Kth node [part by part]
// reverseLinkedList 0(N)- Reversing the complete list [part by part]
// T:0(2N)
// S:0(1)

public class Main {
    public static void main(String[] args) {
        CustomLL5 list = new CustomLL5();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Reverse nodes in groups of 3
        list.kReverse(3);

        // Print the modified list
        System.out.println("List after reversing in groups of 3:");
        list.printList();
    }
}
