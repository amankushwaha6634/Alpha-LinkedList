import java.util.HashSet;
import java.util.Set;

class CustomLL1 {
    Node head; // Head of the linked list

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

    // 🔥 Using Set instead of Map
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        Set<Node> visited = new HashSet<>();

        while (currNode != null) {

            if (visited.contains(currNode)) {
                System.out.println("Loop detected. Stopping printing.");
                break;
            }

            System.out.print(currNode.data + " -> ");
            visited.add(currNode);
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    // 🔥 Using Set instead of Map
    public boolean detectLoop() { // T: O(N) | S: O(N)

        Node temp = head;
        Set<Node> visited = new HashSet<>();

        while (temp != null) {

            if (visited.contains(temp)) {
                return true;
            }

            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // 🔥 START NODE using Set (your required)
    public Node startNodeOfCycle() { // T: O(N) | S: O(N)

        Node temp = head;
        Set<Node> set = new HashSet<>();

        while (temp != null) {

            if (set.contains(temp)) {
                return temp;
            }

            set.add(temp);
            temp = temp.next;
        }

        return null;
    }
}

// Main class
public class Bruteforce {
    public static void main(String[] args) {

        CustomLL1 list = new CustomLL1();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Create loop at node 2
        CustomLL1.Node temp = list.head;
        CustomLL1.Node loopNode = null;
        int position = 2;

        while (temp != null) {
            position--;
            if (position == 0) {
                loopNode = temp;
            }
            temp = temp.next;
        }

        if (loopNode != null) {
            temp = list.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = loopNode;
        }

        System.out.println("List (with loop):");
        list.printList();

        boolean hasLoop = list.detectLoop();
        System.out.println("Does the list have a loop? " + (hasLoop ? "Yes" : "No"));

        CustomLL1.Node cycleStartNode = list.startNodeOfCycle();

        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with data: " + cycleStartNode.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

/**
 * 🎯 Linked List Cycle Operations (Using HashSet) — Algorithm
 *
 * Covers:
 * 1. printList (safe print with loop)
 * 2. detectLoop
 * 3. startNodeOfCycle
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 *
 * - Use HashSet to track visited nodes
 * - If a node repeats → loop detected
 * - First repeated node → start of cycle
 *
 * --------------------------------------------------
 *
 * 🔥 1. printList()
 *
 * Goal:
 * - Print list safely even if loop exists
 *
 * Steps:
 *
 * 1. Initialize:
 *
 *      curr = head
 *      set = empty HashSet
 *
 * 2. Traverse:
 *
 *      while (curr != null)
 *
 * 3. Check:
 *
 *      if (set.contains(curr))
 *          print "Loop detected"
 *          break
 *
 * 4. Print node:
 *
 *      print curr.data
 *
 * 5. Mark visited:
 *
 *      set.add(curr)
 *
 * 6. Move:
 *
 *      curr = curr.next
 *
 * --------------------------------------------------
 *
 * 🔥 2. detectLoop()
 *
 * Goal:
 * - Check if cycle exists
 *
 * Steps:
 *
 * 1. Initialize:
 *
 *      temp = head
 *      set = empty HashSet
 *
 * 2. Traverse:
 *
 *      while (temp != null)
 *
 * 3. Check:
 *
 *      if (set.contains(temp))
 *          return true
 *
 * 4. Store:
 *
 *      set.add(temp)
 *
 * 5. Move:
 *
 *      temp = temp.next
 *
 * 6. End:
 *
 *      return false
 *
 * --------------------------------------------------
 *
 * 🔥 3. startNodeOfCycle()
 *
 * Goal:
 * - Find first node of loop
 *
 * Steps:
 *
 * 1. Initialize:
 *
 *      temp = head
 *      set = empty HashSet
 *
 * 2. Traverse:
 *
 *      while (temp != null)
 *
 * 3. Check repetition:
 *
 *      if (set.contains(temp))
 *          return temp   // start of cycle
 *
 * 4. Store:
 *
 *      set.add(temp)
 *
 * 5. Move:
 *
 *      temp = temp.next
 *
 * 6. If no loop:
 *
 *      return null
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 -> 2 -> 3 -> 4 -> 5
 *           ^______________|
 *
 * Steps:
 *
 *      Visit 1 → store
 *      Visit 2 → store
 *      Visit 3 → store
 *      Visit 4 → store
 *      Visit 5 → store
 *
 *      Next → goes back to 2
 *
 *      2 already exists → return 2 ✅
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time = O(N)
 * 👉 Space = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 *
 * - HashSet gives O(1) lookup
 * - First repeated node = entry of cycle
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 *
 * "I use a HashSet to track visited nodes and detect repetition.
 * The first repeated node is the start of the cycle."
 */