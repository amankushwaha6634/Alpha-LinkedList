import java.util.Stack;

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

    // Method to check if the linked list is a palindrome
    public boolean isPalindrome() { // T:o(2N) s:o(n)
        // Create an empty stack to temporarily store the values of the linked list
        Stack<Integer> st = new Stack<>();

        // Initialize a temporary pointer to traverse the linked list
        Node temp = head;

        // Step 1: Traverse the linked list and push all values onto the stack
        while (temp != null) {
            // Push the data from the current node onto the stack
            st.push(temp.data);

            // Move to the next node in the linked list
            temp = temp.next;
        }

        // Reset the temporary pointer back to the head of the linked list
        temp = head;

        // Step 2: Traverse the linked list again and compare values from the stack
        while (temp != null) {
            // Peek the top value of the stack and compare it with the current node's data
            if (temp.data != st.peek()) {
                // If the values don't match, the linked list is not a palindrome
                return false;
            }

            // Pop the top value from the stack as it matches the current node's data
            st.pop();

            // Move to the next node in the linked list
            temp = temp.next;
        }

        // if execution comes here than all are matched.
        // If all values match during the comparison, the linked list is a palindrome
        return true;
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        // Create the linked list
        CustomLL list = new CustomLL();

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
        if (list.isPalindrome()) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}


/**
 * 🔹 Time & Space Complexity (Stack Approach - Brute Force)
 *
 * Let:
 *      N = number of nodes in linked list
 *
 * --------------------------------------------------
 *
 * 🔹 Step 1: Push all elements into stack
 *
 *      while (temp != null)
 *          st.push(temp.data)
 *
 * - We traverse entire list once
 *
 * 👉 Time = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Step 2: Traverse again and compare
 *
 *      while (temp != null)
 *          compare with st.peek()
 *          st.pop()
 *
 * - Again traverse entire list
 *
 * 👉 Time = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Total Time Complexity:
 *
 *      O(N) + O(N)
 *
 * 👉 Final Time = O(2N) ≈ O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Space Complexity:
 *
 * - Stack stores all N elements
 *
 * 👉 Space = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Summary:
 *
 * 👉 Time Complexity  = O(N)
 * 👉 Space Complexity = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I use a stack to reverse the order virtually and compare
 * in a second traversal. This takes O(N) time and O(N) space."
 */



/*
Stack Operations Time Complexity:

For Java Stack (internally uses Vector / dynamic array):

--------------------------------------------------

🔹 push() → O(1) (amortized)

- Adds element at top
- Usually constant time
- Occasionally resizing happens → O(N), but rare

👉 So overall: O(1) amortized

--------------------------------------------------

🔹 pop() → O(1)

- Removes top element
- No shifting required

--------------------------------------------------

🔹 peek() → O(1)

- Just returns top element
- No modification

--------------------------------------------------

🔹 contains() → O(N) (not used here)

--------------------------------------------------

🔹 In your code:

Step 1:
    push N elements → O(N)

Step 2:
    peek + pop for N elements → O(N)

👉 Total still = O(N)

--------------------------------------------------

🔹 Final Understanding:

Each stack operation (push, pop, peek) is constant time,
so overall algorithm remains linear.
*/