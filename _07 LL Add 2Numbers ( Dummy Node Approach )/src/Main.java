class LinkedList {
    Node head;

    // Node of linked list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert node at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // Move till last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node at end
        temp.next = newNode;
    }

    // Print linked list
    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    /*
        addTwoNumbers(l1, l2)
        ------------------------------------------------------
        Adds two linked lists digit by digit.

        Example:
            l1 = 3 -> 8 -> 7
            l2 = 5 -> 4 -> 4 -> 9

        Calculation:
            3 + 5 = 8
            8 + 4 = 12  -> write 2, carry 1
            7 + 4 + 1 = 12 -> write 2, carry 1
            0 + 9 + 1 = 10 -> write 0, carry 1
            remaining carry = 1

        Result:
            8 -> 2 -> 2 -> 0 -> 1

        Time Complexity  : O(max(m, n))
        Space Complexity : O(max(m, n))
    */
    public LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {

        // Pointer for first list
        Node p1 = l1.head;

        // Pointer for second list
        Node p2 = l2.head;

        /*
            Dummy node helps in easy creation of result list.

            Initially:
                dummy -> null
                current points to dummy
        */
        Node dummy = new Node(0);
        Node current = dummy;

        // Stores carry generated during addition
        int carry = 0;

        // Continue until both lists are completely processed
        while (p1 != null || p2 != null) {

            // Start current sum with previous carry
            int sum = carry;

            // If first list has node
            if (p1 != null) {
                sum = sum + p1.data;
                p1 = p1.next;
            }

            // If second list has node
            if (p2 != null) {
                sum = sum + p2.data;
                p2 = p2.next;
            }

            // Extract carry ( 12 / 10 = 1 )
            carry = sum / 10;

            // Create node with single digit ( 12 % 10 = 2 )
            Node newNode = new Node(sum % 10);

            // Attach node to result list
            current.next = newNode;

            // Move current forward
            current = current.next;
        }

        // If carry still remains after loop
        if (carry > 0) {
            current.next = new Node(carry);
        }

        // Final answer list
        LinkedList result = new LinkedList();

        // Skip dummy node and point to actual first node
        result.head = dummy.next;

        return result;
    }
}

public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        list1.addLast(3);
        list1.addLast(8);
        list1.addLast(7);

        LinkedList list2 = new LinkedList();
        list2.addLast(5);
        list2.addLast(4);
        list2.addLast(4);
        list2.addLast(9);

        System.out.println("List 1:");
        list1.printList();

        System.out.println("List 2:");
        list2.printList();

        LinkedList result = new LinkedList();
        result = result.addTwoNumbers(list1, list2);

        System.out.println("Result:");
        result.printList();
    }
}

/*
A. carry
-----------------
    - Stores carry generated after addition
    - Example:
        8 + 4 = 12
        digit = 2
        carry = 1

B. carry = sum / 10
--------------------
    - Extract carry from sum

    Example:
        sum = 17
        carry = 17/10 = 1

C. sum % 10
----------------
    - Extract actual digit to store in linked list

    Example:
        sum = 17
        digit = 7

D. if (carry > 0)
----------------
    - If carry still remains after loop
    - Add one extra node

    Example:
        last sum = 10
        digit = 0
        carry = 1

        Add final node with value 1
*/


/*
    int sum = carry;
    ----------------
    - Start current sum with previous carry
*/


/*
A.  while (p1 != null || p2 != null)
--------------------------------
    - Continue until both linked lists are completely processed
    - Needed because lists may have different sizes

B.  if (p1 != null)
----------------
    - Add value from first linked list
    - Move p1 to next node

C.  if (p2 != null)
----------------
    - Add value from second linked list
    - Move p2 to next node
*/



/*
    Dummy Node
    -----------------
    Why used?
    - Makes insertion easy
    - Avoids separate handling of first node
    - Prevents losing head of result list

    Initially:
        dummy -> null
        current -> dummy

    At the end:
        result.head = dummy.next
*/
