
class CustomLinkedList {
    Node head; // head of list
    class Node {
        int data;         // Data stored in the node
        Node next;        // Reference to the next node in the linked list

        public Node(int data1) {
            this.data = data1;  // Initialize data with the provided value
            this.next = null;   // Initialize next as null since it's the end of the list
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){ // reach last node
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void printList(){
        if(head == null){
            System.out.println("List Is Empty");
            return;
        }
        Node currNode = head;
        while(currNode!=null){ // reach last node
            System.out.print(currNode.data +" -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    /*
    1) deleteFirst()
        --------------------------------------------------------------
        - Removes the first node (head) of the list.

        Steps:
        - If list is empty → nothing to delete
        - Move head to next node

        Effect:
        Before: head -> [1] -> [2] -> [3]
        After:  head -> [2] -> [3]

        Time Complexity: O(1)
    */
    public void deleteFirst(){
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        head= head.next;
    }

    /*
    2) deleteLast()
        --------------------------------------------------------------
        - Removes the last node of the list.

        Steps:
        - If list is empty → return
        - If only one node → head = null
        - Otherwise:
          - Traverse till second last node
          - Set secondLast.next = null

        Effect:
        Before: [1] -> [2] -> [3]
        After:  [1] -> [2]

        Time Complexity: O(n)
     */
    public void deleteLast(){
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if(head.next ==null){ // may be the case if only 1 node is there
            head = null; // delete 1st node
            return;
        }
        // if execution is coming in this line it mean no of nodes > 1

        Node temp = head;

        // Traverse the list until the second-to-last node
        while (temp.next.next != null) { // null.next may be the case if only 1 node is there ( handled above )
            temp = temp.next;
        }
        // Nullify the connection from the second-to-last node to delete the last node
        temp.next = null;

    }


    /*
    3) deleteByPosition(k)
        --------------------------------------------------------------
        - Deletes node at position k (1-based index)

        Steps:
        - If k == 1 → delete first node
        - Traverse till k-th node
        - Keep track of previous node
        - Skip k-th node:
          prev.next = temp.next

        Effect (k=2):
        Before: [1] -> [2] -> [3]
        After:  [1] -> [3]

        Time Complexity: O(n)
     */
    public void deleteByPosition(int k) {
        // Check if the list is empty
        if (head == null)
            return;

        // If k is 1, delete the first node
        if (k == 1) {
            head = head.next;
            return;
        }

        // Traverse the list to find the k-th node
        Node temp = head;
        Node prev = null;
        int cnt = 0;

        while (temp != null) {
            cnt++;
            // If the k-th node is found
            if (cnt == k) {
                // Adjust the pointers to skip the k-th node
                prev.next = temp.next;
                break;
            }
            // Move to the next node
            prev = temp;
            temp = temp.next;
        }
    }

    /*
    4) deleteByValue(val)
        --------------------------------------------------------------
        - Deletes first node with given value

        Steps:
        - If head has value → delete first node
        - Traverse list
        - Find node with value
        - Skip it:
          prev.next = temp.next

        Effect (val=2):
        Before: [1] -> [2] -> [3]
        After:  [1] -> [3]

        Time Complexity: O(n)
     */
    public void deleteByValue(int val) {
        // Check if the list is empty
        if (head == null)
            return;

        // If the first node has the target value, delete it
        if (head.data == val) {
            head = head.next;
            return;
        }

        // If execution comes here it definitely
        // A. means length >= 2
        // B. deleteable value is not at head.
        //    So in case node is deletable than prev will be head so prev will never be null.
        // Traverse the list to find the node with the target value
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                // Adjust the pointers to skip the node with the target value
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }


}
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        for (int i = 0; i < 9; i++) {
            list.addLast(i);
        }
        list.printList();
        // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null

        System.out.println("-------------------------------------------");

        list.deleteFirst();
        list.printList();
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null

        list.deleteLast();
        list.printList();
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null

        System.out.println("------------------------------------------------------");

        list.deleteByPosition(2);
        list.printList(); // After deleting the element at position 2
        // 1 -> 3 -> 4 -> 5 -> 6 -> 7 -> null

        list.deleteByValue(7);
        list.printList(); // After deleting the node with value 7
        // 1 -> 3 -> 4 -> 5 -> 6 -> null
    }
}

/*
--------------------------------------------------------------
KEY POINTS (INTERVIEW)
--------------------------------------------------------------
- Always handle edge cases:
  • empty list
  • single node
  • deleting head

- Deletion = "skip the node"
  → prev.next = temp.next

- No need to explicitly free memory in Java
==============================================================
 */