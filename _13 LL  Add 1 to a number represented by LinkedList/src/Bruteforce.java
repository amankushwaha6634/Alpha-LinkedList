class CustomLL {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // 🔥 USING % and /
    public void addOne() {

        // Reverse list
        Node newHead = reverseList(head);

        Node current = newHead;
        int carry = 1;

        while (current != null) {

            int sum = current.data + carry;

            // 🔥 Core logic using % and /
            current.data = sum % 10;
            carry = sum / 10;

            // If no carry, break early
            if (carry == 0) {
                break;
            }

            current = current.next;
        }

        // Reverse back
        head = reverseList(newHead);

        // If carry still left → add new node at front
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
    }

    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}

public class Bruteforce {
    public static void main(String[] args) {

        CustomLL list = new CustomLL();

        list.addLast(9);
        list.addLast(9);
        list.addLast(9);

        System.out.println("Original List:");
        list.printList();

        list.addOne();

        System.out.println("After adding 1:");
        list.printList();
    }
}

/**
 * 🎯 Add 1 to Number Represented by Linked List (Using % and /) — Algorithm
 *
 * 🔹 Problem:
 * - Linked list represents a number:
 *      1 -> 2 -> 3  = 123
 *
 * - Add 1 to this number
 *
 *      Result:
 *      1 -> 2 -> 4
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Reverse list → so we can start from least significant digit
 * - Add 1 with carry
 * - Use:
 *      digit = sum % 10
 *      carry = sum / 10
 * - Reverse back
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Reverse the linked list:
 *
 *      newHead = reverse(head)
 *
 * --------------------------------------------------
 *
 * 2. Initialize:
 *
 *      current = newHead
 *      carry = 1   // because we are adding 1
 *
 * --------------------------------------------------
 *
 * 3. Traverse the reversed list:
 *
 *      while (current != null)
 *
 *          sum = current.data + carry
 *
 *          current.data = sum % 10
 *          carry = sum / 10
 *
 *          if (carry == 0)
 *              break
 *
 *          current = current.next
 *
 * --------------------------------------------------
 *
 * 4. Reverse the list again:
 *
 *      head = reverse(newHead)
 *
 * --------------------------------------------------
 *
 * 5. If carry still remains:
 *
 *      create new node with carry
 *      attach at front:
 *
 *      newNode.next = head
 *      head = newNode
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      9 -> 9 -> 9
 *
 * Step 1:
 *      9 -> 9 -> 9  (reversed same)
 *
 * Step 2:
 *
 *      sum = 9 + 1 = 10
 *      digit = 0, carry = 1
 *
 *      sum = 9 + 1 = 10
 *      digit = 0, carry = 1
 *
 *      sum = 9 + 1 = 10
 *      digit = 0, carry = 1
 *
 * Step 3:
 *      reverse back → 0 -> 0 -> 0
 *
 * Step 4:
 *      carry = 1 → add new node
 *
 * Final:
 *      1 -> 0 -> 0 -> 0
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)   (reverse + traverse + reverse)
 * 👉 Space = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I reverse the list to simulate addition from least significant digit,
 * use modulo and division to handle digit and carry, then reverse back,
 * achieving O(N) time and O(1) space."
 */



/**
 * 🔹 Time & Space Complexity — Add 1 to Linked List (Using % and /)
 *
 * Let:
 *      N = number of nodes in linked list
 *
 * --------------------------------------------------
 *
 * 🔹 Step 1: Reverse the linked list
 *
 *      reverseList(head)
 *
 * - Traverses entire list once
 *
 * 👉 Time = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Step 2: Add 1 with carry (traversal)
 *
 *      while (current != null)
 *
 * - In worst case (e.g., 9->9->9), we traverse all nodes
 * - In best case (e.g., 1->2->3),  we stop early
 *
 * 👉 Time = O(N) (worst case)
 *
 * --------------------------------------------------
 *
 * 🔹 Step 3: Reverse again
 *
 *      reverseList(newHead)
 *
 * 👉 Time = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Step 4: Optional new node creation
 *
 * - Constant time
 *
 * 👉 Time = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Total Time Complexity:
 *
 *      O(N) + O(N) + O(N)
 *
 * 👉 Final Time = O(3N) ≈ O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Space Complexity:
 *
 * - No extra data structures used
 * - Only a few pointers (prev, current, next)
 *
 * 👉 Space = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Summary:
 *
 * 👉 Time Complexity  = O(N)
 * 👉 Space Complexity = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I reverse the list, perform addition with carry in one pass,
 * and reverse it back, resulting in O(N) time and O(1) space."
 */