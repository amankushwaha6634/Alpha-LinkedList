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

    /**
     * Adds a new node at the end of the list.
     * @param data the value to be added.
     */
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

    /**
     * Prints the doubly linked list from head to tail.
     */
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

    /**
     * Deletes the first node of the list.
     */
    /*
    1) addFirst(data)
        --------------------------------------------------------------
        - Inserts node at beginning (head)

        Steps:
        - Create new node
        - newNode.next = head
        - head.prev = newNode
        - head = newNode

        Effect:
        Before: [1] <-> [2] <-> [3]
        After:  [0] <-> [1] <-> [2] <-> [3]

        Time Complexity: O(1)
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // Only one node
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;

    }

    /**
     * Deletes the last node of the list.
     */
    /*
    2) addLast(data)
        --------------------------------------------------------------
        - Inserts node at end

        Steps:
        - Create new node
        - Traverse till last node
        - last.next = newNode
        - newNode.prev = last

        Effect:
        Before: [1] <-> [2] <-> [3]
        After:  [1] <-> [2] <-> [3] <-> [4]

        Time Complexity: O(n)
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // Only one node
            head = null;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.prev.next = null;
    }

    /**
     * Deletes a node by its position (1-based index).
     * @param k the position of the node to be deleted.
     */
    public void deleteByPosition(int k) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node kNode = head;
        int count = 0;
        while (kNode != null ) {
            count++;
            if(count == k){
                break;
            }
            kNode = kNode.next;
        }

        // If the position k is greater than the length of the list
        if (kNode == null) {
            System.out.println("Position out of range");
            return;
        }

        Node prev = kNode.prev;
        Node front = kNode.next;

        // Case: Only one element in the list
        if (prev == null && front == null) {
            head = null;
            return;
        }
        // Case: Deleting the first node
        else if (prev == null) {
            deleteFirst();
            return;
        }
        // Case: Deleting the last node
        else if (front == null) {
            deleteLast();
            return ;
        }

        // else when prev & next are not null
        // Case: Deleting a middle node
        prev.next = front;
        front.prev = prev;

    }

    /**
     * Deletes a node by its value.
     * @param val the value of the node to be deleted.
     */
    public void deleteByValue(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node kNode = head;
        while (kNode != null ) {
            if(kNode.data == val){
                break;
            }
            kNode = kNode.next;
        }

        // If value is not found
        if (kNode == null) {
            System.out.println("Value is not available in the DLL");
            return;
        }

        Node prev = kNode.prev;
        Node front = kNode.next;

        // Case: Only one element in the list
        if (prev == null && front == null) {
            head = null;
            return;
        }
        // Case: Deleting the first node
        else if (prev == null) {
            deleteFirst();
            return;
        }
        // Case: Deleting the last node
        else if (front == null) {
            deleteLast();
            return ;
        }

        // else when prev & next are not null
        // Case: Deleting a middle node
        prev.next = front;
        front.prev = prev;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        for (int i = 0; i < 9; i++) {
            list.addLast(i);
        }
        list.printList();

        System.out.println("-------------------------------------------");

        list.deleteFirst();
        list.printList(); // After deleting the first node

        list.deleteLast();
        list.printList(); // After deleting the last node

        System.out.println("------------------------------------------------------");

        list.deleteByPosition(2);
        list.printList(); // After deleting the element at position 2

        list.deleteByValue(7);
        list.printList(); // After deleting the node with value 7
    }
}
