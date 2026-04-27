import java.util.ArrayList;
import java.util.List;
class CustomDoublyLinkedList {
    Node head; // Head of the doubly linked list

    // Definition of a Node in the doubly linked list
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node
        Node prev; // Reference to the previous node

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a new node at the end of the list
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
        newNode.prev = currNode;
    }

    // Method to print the doubly linked list from head to tail
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " <-> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // Brute-force method to find all pairs with a given sum in the doubly linked list
    public List<List<Integer>> findAllPairsWithSum(int targetSum) { // T: O(N^2) | S: O(K)

        List<List<Integer>> ds = new ArrayList<>(); // DS to store pairs
        // [ ]

        if (head == null) {
            return ds;
        }

        Node temp1 = head;

        while (temp1 != null) {

            Node temp2 = temp1.next;

            while (temp2 != null && temp1.data + temp2.data <= targetSum) {

                if (temp1.data + temp2.data == targetSum) {

                    List<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);

                    ds.add(pair);
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        /*
        Step 0:
        ds = [ ]

        Step 1:
        add (2, 8)
        ds = [ [2, 8] ]

        Step 2:
        add (3, 7)
        ds = [ [2, 8], [3, 7] ]
         */

        return ds;
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);
        list.addLast(7);
        list.addLast(8);

        System.out.println("Original List:");
        list.printList();

        System.out.println("\nPairs with sum 10:");
        list.findAllPairsWithSum(10);  // Looking for pairs that sum to 10
    }
}


/*
🔹 Find All Pairs with Given Sum (Brute + DS) — Complexity

--------------------------------------------------
| Metric              | Complexity               |
--------------------------------------------------
| Time Complexity     | O(N^2)                   |
| Space Complexity    | O(K)                     |
--------------------------------------------------

🔹 Why Time = O(N^2)?

- Outer loop runs for every node → N times

      temp1 = head → tail

- Inner loop runs for remaining nodes

      temp2 = temp1.next → end

👉 Total comparisons:

      (N-1) + (N-2) + ... + 1
      = N(N-1)/2
      ≈ O(N^2)

--------------------------------------------------

🔹 Optimization used:

      while (temp2 != null && sum <= target)

👉 Since list is sorted,
   we break early when sum exceeds target

👉 But worst case still O(N^2)

--------------------------------------------------

🔹 Why Space = O(K)?

- We are storing pairs in:

      List<List<Integer>> ds

- Let:
      K = number of valid pairs

👉 Each pair uses constant space (2 integers)

👉 Total space = O(K)

--------------------------------------------------

🔹 Best / Worst Case:

Case 1: No pairs
    ds = [ ]
    Space = O(1)

Case 2: Many pairs
    e.g. all combinations valid

    Space = O(K)

--------------------------------------------------

🔹 Extra Space (ignoring output):

👉 Only pointers used → O(1)

--------------------------------------------------

🔹 Key Insight:

- Time is high due to nested loops
- Space depends only on number of results

--------------------------------------------------

🔹 Interview Line:

"I use two nested pointers giving O(N^2) time,
and store results in a list, so space is O(K)."
*/
