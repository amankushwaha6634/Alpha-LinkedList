class CustomLinkedList {
    Node head; // head of list

    class Node {
        int data;   // value stored in node
        Node next;  // points to next node

        public Node(int data1) {
            this.data = data1;   // store given value
            this.next = null;    // initially next is null
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data); // create new node

        if (head == null) {            // if list is empty
            head = newNode;            // new node becomes head
            return;
        }

        newNode.next = head;           // point new node to current head
        head = newNode;                // move head to new node
    }

    public void addLast(int data) {
        Node newNode = new Node(data); // create new node

        if (head == null) {            // if list is empty
            head = newNode;            // new node becomes head
            return;
        }

        Node currNode = head;          // start from head

        while (currNode.next != null) { // move until last node
            currNode = currNode.next;
        }

        currNode.next = newNode;       // attach new node at end
    }

    public void insertByPosition(int k, int val) {
        Node newNode = new Node(val);  // create new node

        if (k == 1) {                  // if inserting at first position
            newNode.next = head;       // new node points to current head
            head = newNode;            // head becomes new node
            return;
        }

        int cnt = 0;                   // position counter
        Node temp = head;              // start traversal from head

        while (temp != null) {         // traverse list
            cnt++;                     // increase counter

            if (cnt == k - 1) {        // reached previous position
                newNode.next = temp.next; // new node points to next node
                temp.next = newNode;      // previous node points to new node
                break;                    // insertion done
            }

            temp = temp.next;          // move forward
        }
    }

    public void insertBeforeValue(int k, int val) {
        Node newNode = new Node(val);  // create new node

        if (head == null) {            // if list is empty
            return;                    // nothing to do
        }

        if (head.data == k) {          // if target value is at head
            newNode.next = head;       // new node points to head
            head = newNode;            // new node becomes head
            return;
        }

        Node temp = head;              // start from head

        while (temp.next != null) {    // move until next node exists
            if (temp.next.data == k) { // found target value in next node
                newNode.next = temp.next; // new node points to target node
                temp.next = newNode;      // current node points to new node
                break;                    // insertion done
            }
            temp = temp.next;          // move forward
        }
    }

    public void printList() {
        if (head == null) {            // if list is empty
            System.out.println("List Is Empty");
            return;
        }

        Node currNode = head;          // start from head

        while (currNode != null) {     // traverse till end
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");    // end of list
    }
}

public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        // head = null
        // list is empty

        list.addFirst(1);
        // newNode = 1
        // head was null, so head = 1
        // list: 1 -> null

        list.addFirst(2);
        // newNode = 2
        // newNode.next = 1
        // head = 2
        // list: 2 -> 1 -> null

        list.addFirst(3);
        // newNode = 3
        // newNode.next = 2
        // head = 3
        // list: 3 -> 2 -> 1 -> null

        list.addFirst(4);
        // newNode = 4
        // newNode.next = 3
        // head = 4
        // list: 4 -> 3 -> 2 -> 1 -> null

        list.addFirst(5);
        // newNode = 5
        // newNode.next = 4
        // head = 5
        // list: 5 -> 4 -> 3 -> 2 -> 1 -> null

        list.printList();
        // output: 5 -> 4 -> 3 -> 2 -> 1 -> null

        list.addLast(98);
        // newNode = 98
        // traverse from 5 to 1
        // last node is 1
        // 1.next = 98
        // list: 5 -> 4 -> 3 -> 2 -> 1 -> 98 -> null

        list.addLast(99);
        // newNode = 99
        // traverse from 5 to 98
        // last node is 98
        // 98.next = 99
        // list: 5 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        list.printList();
        // output: 5 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        System.out.println("------------------------------------------------------");

        list.insertByPosition(2, 99999);
        // k = 2, val = 99999
        // create newNode = 99999
        // need to insert at position 2
        // temp starts at head = 5
        // cnt = 1, and cnt == k-1
        // newNode.next = temp.next = 4
        // temp.next = newNode
        // list: 5 -> 99999 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        list.printList();
        // output: 5 -> 99999 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        list.insertBeforeValue(99999, 888);
        // k = 99999, val = 888
        // create newNode = 888
        // head.data = 5, not 99999
        // temp starts at 5
        // temp.next.data = 99999, target found
        // newNode.next = temp.next = 99999
        // temp.next = newNode
        // list: 5 -> 888 -> 99999 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        list.printList();
        // output: 5 -> 888 -> 99999 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null
    }
}