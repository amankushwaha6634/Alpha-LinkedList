import java.util.HashSet;

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

    // Utility function to check presence of intersection between two linked lists
    static Node intersectionPresent(Node head1, Node head2) { // T: 0(N1+N2)  S: 0(N1)- if we are storing first LL, 0(N2)-if we are storing 2nd LL
        // Check if either list is null
        if (head1 == null || head2 == null) {
            return null; // If either list is null, there's no intersection
        }
        // Create a HashSet to store the nodes of the first linked list
        HashSet<Node> st = new HashSet<>();

        // Traverse the first linked list and add each node to the hash set
        // This will allow us to later check if a node in the second list is already in the hash set
        while (head1 != null) { // T: 0(N1 * whatever our hashset takes time to insert(maybe logarithmic/constant etc in our case lets take constant ) => 0(N1)
            st.add(head1); // Add the current node of the first list to the hash set
            head1 = head1.next; // Move to the next node in the first list
        }

        // Traverse the second linked list and check if any node is already in the hash set
        // If a node is found in the hash set, it means this node is common to both lists (i.e., intersection point)
        while (head2 != null) { // T: 0(N2 * whatever our hashset takes time to check(maybe logarithmic/constant etc in our case lets take constant ) => 0(N2)
            if (st.contains(head2)) { // Check if the current node of the second list exists in the hash set
                return head2;  // Intersection point found, return the node
            }
            head2 = head2.next; // Move to the next node in the second list
        }

        // If no intersection is found after traversing both lists, return null
        return null;  // No intersection found
    }
}

// Main class to test the CustomLL2 class and intersectionPresent method
public class Hashing {
    public static void main(String[] args) {
        // Create two linked lists
        CustomLL2 list1 = new CustomLL2();
        CustomLL2 list2 = new CustomLL2();

        // Adding sample nodes to list1 (e.g., 1 -> 2 -> 3)
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        // Adding sample nodes to list2 (e.g., 4 -> 5) and then create an intersection at node 2
        list2.addLast(4);
        list2.addLast(5);
        list2.head.next.next = list1.head.next; // Creating intersection at node 2

        // Print both linked lists
        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        // Find the intersection point
        CustomLL2.Node intersectionNode = CustomLL2.intersectionPresent(list1.head, list2.head);

        // Print the intersection result
        if (intersectionNode != null) {
            System.out.println("Intersection point at node with data: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}



/**
 * 🔹 Time Complexity Analysis:
 *
 * Let:
 *      N1 = number of nodes in first linked list
 *      N2 = number of nodes in second linked list
 *
 * --------------------------------------------------
 *
 * Step 1: Insert all nodes of first linked list into HashSet
 *
 *      while (head1 != null)
 *          st.add(head1)
 *
 * - We traverse all N1 nodes once
 * - HashSet insertion takes O(1) average time
 *
 * 👉 Time = O(N1)
 *
 * --------------------------------------------------
 *
 * Step 2: Traverse second linked list and check in HashSet
 *
 *      while (head2 != null)
 *          st.contains(head2)
 *
 * - We traverse all N2 nodes once
 * - HashSet lookup takes O(1) average time
 *
 * 👉 Time = O(N2)
 *
 * --------------------------------------------------
 *
 * Total Time Complexity:
 *
 *      O(N1) + O(N2)
 *
 * 👉 Final Time Complexity = O(N1 + N2)
 *
 * --------------------------------------------------
 *
 * 🔹 Space Complexity Analysis:
 *
 * - We store all nodes of first linked list inside HashSet
 * - In worst case, HashSet stores N1 nodes
 *
 * 👉 Space Complexity = O(N1)
 *
 * (If instead we stored second linked list in HashSet,
 * then space would become O(N2))
 */