import java.util.HashSet;

class CustomLL4 {
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

    static Node intersectionPresent(Node head1, Node head2) {

        // If any list is empty, no intersection is possible
        if (head1 == null || head2 == null) {
            return null;
        }

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != t2) {

            // Move both pointers one step ahead
            t1 = t1.next;
            t2 = t2.next;

            // If both become same after moving, intersection found
            if (t1 == t2) {
                return t1;
            }

            // If t1 reaches end of first list,
            // start traversing second list
            if (t1 == null) {
                t1 = head2;
            }

            // If t2 reaches end of second list,
            // start traversing first list
            if (t2 == null) {
                t2 = head1;
            }
        }

        return t1;
    }


}

// Main class to test the CustomLL2 class and intersectionPresent method
public class Optimised {
    public static void main(String[] args) {
        // Create two linked lists
        CustomLL4 list1 = new CustomLL4();
        CustomLL4 list2 = new CustomLL4();

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
        CustomLL4.Node intersectionNode = CustomLL4.intersectionPresent(list1.head, list2.head);

        // Print the intersection result
        if (intersectionNode != null) {
            System.out.println("Intersection point at node with data: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}


/*
Intuition Behind This Algorithm:

Suppose:

List1 = 1 -> 2 -> 3 -> 4 -> 5
List2 = 9 -> 4 -> 5

Intersection starts from node 4.

Unique part of List1 = [1, 2, 3]
Unique part of List2 = [9]

------------------------------------------------

Problem:
One list may be longer than the other.

So if we move both pointers together from start,
they will not reach the intersection at same time.

Example:

    t1: 1 -> 2 -> 3 -> 4 -> 5
    t2: 9 -> 4 -> 5

t1 reaches later because list1 is longer.

------------------------------------------------

Idea:
Make both pointers travel equal total distance.

How?

When t1 finishes list1,
send it to start of list2.

When t2 finishes list2,
send it to start of list1.

So finally:

t1 travels:
    length(list1) + length(list2)

t2 also travels:
    length(list2) + length(list1)

Therefore both travel exactly same distance.

------------------------------------------------

Suppose:

List1 = A + C
List2 = B + C

where:

A = unique nodes of list1
B = unique nodes of list2
C = common intersection part

Then:

t1 travels:
    A + C + B

t2 travels:
    B + C + A

Both total lengths become same:

    A + C + B = B + C + A

So after covering unequal parts A and B,
both pointers reach C together.

That is why they meet exactly at intersection node.

------------------------------------------------

If there is NO intersection:

Then both pointers will eventually finish both lists
and become null at same time.

So loop stops and returns null.
*/