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

    /*
    1) addFirst(data)
        --------------------------------------------------------------
        - Inserts node at beginning (head)

        Steps:
        - Create new node
        - Point newNode.next to current head
        - Move head to new node

        Effect:
        Before: [1] -> [2] -> [3]
        After:  [0] -> [1] -> [2] -> [3]

        Time Complexity: O(1)
     */
    public void addFirst(int data) {
        Node newNode = new Node(data); // create new node

        if (head == null) {            // if list is empty
            head = newNode;            // new node becomes head
            return;
        }

        newNode.next = head;           // point new node to current head
        head = newNode;                // move head to new node
    }

    /*
    2) addLast(data)
        --------------------------------------------------------------
        - Inserts node at end of list

        Steps:
        - Create new node
        - Traverse till last node
        - Set last.next = newNode

        Effect:
        Before: [1] -> [2] -> [3]
        After:  [1] -> [2] -> [3] -> [4]

        Time Complexity: O(n)
     */
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

    /*
    3) insertByPosition(k, val)  (USING prev)
    --------------------------------------------------------------
    - Inserts node at position k (1-based index)

    Steps:
    - If k == 1 → insert at head
    - Traverse till kth node
    - Maintain prev pointer
    - Insert:
        prev.next = newNode
        newNode.next = temp

    Effect (k=2):
    Before: [1] -> [2] -> [3]
    After:  [1] -> [X] -> [2] -> [3]

    Time Complexity: O(n)
    */
    public void insertByPosition(int k, int val) {

        Node newNode = new Node(val);  // create new node

        // Insert at head
        if (k == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        Node prev = null;
        int cnt = 0;

        while (temp != null) {
            cnt++;

            // When kth position reached
            if (cnt == k) {
                prev.next = newNode;   // connect prev → newNode
                newNode.next = temp;   // connect newNode → temp
                break;
            }

            prev = temp;       // move prev
            temp = temp.next;  // move temp
        }

        if(cnt + 1 == k){
            prev.next = newNode;
        }
    }

    /*
    4) insertBeforeValue(k, val)  (USING prev)
    --------------------------------------------------------------
    - Inserts node before a given value

    Steps:
    - If list empty → return
    - If head has value → insert at beginning
    - Traverse using prev & temp
    - When temp.data == k:
        prev.next = newNode
        newNode.next = temp

    Effect (insert before 2):
    Before: [1] -> [2] -> [3]
    After:  [1] -> [X] -> [2] -> [3]

    Time Complexity: O(n)
    */
    public void insertBeforeValue(int k, int val) {

        Node newNode = new Node(val); // create new node

        if (head == null) return;

        // If inserting before head
        if (head.data == k) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {

            if (temp.data == k) {
                prev.next = newNode;   // connect prev → newNode
                newNode.next = temp;   // connect newNode → temp
                return;
            }

            prev = temp;
            temp = temp.next;
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
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.printList();
        // output: 5 -> 4 -> 3 -> 2 -> 1 -> null

        list.addLast(98);
        // newNode = 98
        // traverse from 5 to 1
        // last node is 1
        // 1.next = 98
        // list: 5 -> 4 -> 3 -> 2 -> 1 -> 98 -> null

        list.addLast(99);
        list.printList();
        // output: 5 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        System.out.println("------------------------------------------------------");

        list.insertByPosition(2, 99999);
        list.printList();
        // output: 5 -> 99999 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null

        list.insertBeforeValue(99999, 888);
        list.printList();
        // output: 5 -> 888 -> 99999 -> 4 -> 3 -> 2 -> 1 -> 98 -> 99 -> null
    }
}

/*
    KEY POINTS (INTERVIEW)
--------------------------------------------------------------
        - Insertion = "adjust links without losing nodes"
        - Always connect new node before breaking old link
        - Handle edge cases:
        • empty list
        • inserting at head
        • position out of range

        --------------------------------------------------------------

        ONE-LINE MEMORY TRICK
        --------------------------------------------------------------
        Insertion = "newNode.next first, then connect previous"
 */