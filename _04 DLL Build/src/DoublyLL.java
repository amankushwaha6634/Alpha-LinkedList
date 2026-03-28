public class DoublyLL {

    Node head; // head of doubly linked list

    class Node {
        int data;   // value stored in node
        Node prev;  // points to previous node
        Node next;  // points to next node

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /*
    ==============================================================
    convertArrToDLL(arr)
    --------------------------------------------------------------
    - Converts array into Doubly Linked List
    - Stores first node in head

    Steps:
    - Create head using first element
    - Maintain tail pointer
    - For each next element:
        • create node
        • tail.next = temp
        • temp.prev = tail
        • move tail forward
    ==============================================================
    */
    public void convertArrToDLL(int[] arr) {

        // create first node and assign to head
        head = new Node(arr[0]);

        // tail points to last inserted node
        Node tail = head;

        // start from second element
        for (int i = 1; i < arr.length; i++) {

            Node temp = new Node(arr[i]); // create new node

            tail.next = temp; // forward link
            temp.prev = tail; // backward link

            tail = temp; // move tail forward
        }
    }

    /*
    ==============================================================
    printDLL()
    --------------------------------------------------------------
    - Prints doubly linked list in forward direction
    ==============================================================
    */
    public void printDLL() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    /*
    ==============================================================
    lengthDLL()
    --------------------------------------------------------------
    - Returns number of nodes in DLL
    ==============================================================
    */
    public void lengthDLL() {

        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Length = " + count);
    }
}

class Main {
    public static void main(String[] args) {

        int[] arr = {2, 5, 8, 7};

        DoublyLL dll = new DoublyLL();

        // convert array into doubly linked list
        dll.convertArrToDLL(arr);

        // print DLL
        dll.printDLL();

        // print length
        dll.lengthDLL();
    }
}

/*
==================== DRY RUN ====================

arr = {2, 5, 8, 7}

Step 1:
head = 2
prev = 2

List:
2

--------------------------------

i = 1 → value = 5
temp = 5

prev.next = temp → 2 -> 5
temp.prev = prev → 5 <- 2

prev = 5

List:
2 <-> 5

--------------------------------

i = 2 → value = 8
temp = 8

5 -> 8
8 <- 5

prev = 8

List:
2 <-> 5 <-> 8

--------------------------------

i = 3 → value = 7
temp = 7

8 -> 7
7 <- 8

prev = 7

Final List:
2 <-> 5 <-> 8 <-> 7 <-> null

================================================

KEY IDEA:
- Always connect BOTH directions:
    prev.next = temp
    temp.prev = prev
*/