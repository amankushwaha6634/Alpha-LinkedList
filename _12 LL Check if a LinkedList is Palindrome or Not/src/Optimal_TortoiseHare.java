class CustomLL2 {
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

    // Method to reverse a linked list starting from a given node
    private Node reverse(Node head) {
        Node prev = null;   // Initialize previous pointer as null
        Node current = head; // Start from the given head node
        while (current != null) {
            Node nextNode = current.next; // Temporarily store the next node
            current.next = prev;          // Reverse the current node's pointer
            prev = current;               // Move the previous pointer forward
            current = nextNode;           // Move the current pointer forward
        }
        return prev; // Return the new head of the reversed list
    }

    // Method to check if the linked list is a palindrome
    public boolean isPalindrome() { // T: 0(2N) S:0(1)
        // Step 1: Handle edge cases - An empty or single-node list is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 2: Use slow and fast pointers to find the middle of the list
        Node slow = head;
        Node fast = head;

/*
Using:
    while (fast.next != null && fast.next.next != null)

Now slow stops one node before the middle
(for odd length) or before second half (for even length)

Examples:

    1 -> 2 -> 3 -> 2 -> 1
             ^
           slow = 2

    1 -> 2 -> 2 -> 1
         ^
       slow = 2(first)
*/
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Node before second half: " + slow.data);

// Reverse only the second half
        Node secondHalf = reverse(slow.next);

// Keep copy so we can restore later
        Node secondHalfCopy = secondHalf;

// Compare first half and reversed second half
        Node firstHalf = head;
        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

// Restore original linked list
        slow.next = reverse(secondHalfCopy);

        // Step 6: Return the result
        return isPalindrome; // Return true if the list is a palindrome, otherwise false
    }
}

// Main class to test the CustomLL2 class and isPalindrome method
public class Optimal_TortoiseHare {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL2 list = new CustomLL2();

        // Adding sample nodes to the linked list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        // Print the original list
        System.out.println("Original List:");
        list.printList();

        // Check if the linked list is a palindrome
        boolean result = list.isPalindrome();

        // Print the result
        System.out.println("Is the list a palindrome? " + result);

        // Print the list again to ensure it is unchanged
        System.out.println("List after palindrome check:");
        list.printList();
    }
}
