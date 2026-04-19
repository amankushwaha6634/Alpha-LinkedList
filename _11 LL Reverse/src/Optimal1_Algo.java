
public class Optimal1_Algo {
}
/**
 * 🎯 Reverse Linked List Using Iteration — Notes
 *
 * 🔹 Problem:
 * - Reverse the entire linked list
 * - Change direction of every next pointer
 *
 * Example:
 *
 *      Original:
 *      1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 *      Final:
 *      5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Traverse the linked list once
 * - For every node, reverse its next pointer
 * - Keep track of:
 *
 *      1. Previous node
 *      2. Current node
 *      3. Next node
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 *      prev  = null
 *      temp  = head
 *      front = temp.next
 *
 * --------------------------------------------------
 *
 * 🔹 Why front Variable?
 *
 * Before reversing:
 *
 *      temp.next = prev
 *
 * we would lose the remaining linked list.
 *
 * So first save next node:
 *
 *      front = temp.next
 *
 * Then reverse safely.
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Initialize:
 *
 *      prev = null
 *      temp = head
 *
 * 2. Traverse while:
 *
 *      while (temp != null)
 *
 * 3. Save next node:
 *
 *      front = temp.next
 *
 * 4. Reverse current node pointer:
 *
 *      temp.next = prev
 *
 * 5. Move prev forward:
 *
 *      prev = temp
 *
 * 6. Move temp forward:
 *
 *      temp = front
 *
 * 7. After loop:
 *
 *      head = prev
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 * Initially:
 *
 *      prev = null
 *      temp = 1
 *
 * Iteration 1:
 *
 *      front = 2
 *      1.next = null
 *
 *      prev = 1
 *      temp = 2
 *
 * List becomes:
 *
 *      1 -> null
 *      2 -> 3 -> 4 -> 5
 *
 * Iteration 2:
 *
 *      front = 3
 *      2.next = 1
 *
 *      prev = 2
 *      temp = 3
 *
 * List becomes:
 *
 *      2 -> 1 -> null
 *      3 -> 4 -> 5
 *
 * Iteration 3:
 *
 *      front = 4
 *      3.next = 2
 *
 *      prev = 3
 *      temp = 4
 *
 * Iteration 4:
 *
 *      front = 5
 *      4.next = 3
 *
 *      prev = 4
 *      temp = 5
 *
 * Iteration 5:
 *
 *      front = null
 *      5.next = 4
 *
 *      prev = 5
 *      temp = null
 *
 * Loop Ends
 *
 * Final:
 *
 *      head = prev
 *
 *      5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * --------------------------------------------------
 *
 * 🔹 Why Does List Not Break?
 *
 * Before changing:
 *
 *      temp.next = prev
 *
 * we already save:
 *
 *      front = temp.next
 *
 * So even after reversing the pointer,
 * we still know where remaining list starts.
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * 👉 Time Complexity = O(N)
 *
 * 👉 Space Complexity = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 * "I reverse the linked list in-place by maintaining previous,
 * current, and next pointers. For every node, I reverse its next
 * pointer, achieving O(N) time and O(1) space."
 */

