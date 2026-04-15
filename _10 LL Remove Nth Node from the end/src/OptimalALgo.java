
class OptimalALgo {
}
/**
 * 🎯 Delete Nth Node From End of Linked List — Notes
 *
 * 🔹 Problem:
 * - Delete the Nth node from the end of the linked list
 *
 * Example:
 *
 *      Linked List:
 *      1 -> 2 -> 3 -> 4 -> 5
 *
 *      N = 2
 *
 *      Node to Delete = 4
 *
 *      Final:
 *      1 -> 2 -> 3 -> 5
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Use two pointers:
 *      1. fast
 *      2. slow
 *
 * - Move fast pointer N steps ahead
 * - Then move both pointers together
 * - When fast reaches the last node,
 *   slow will be just before the node to delete
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 *      fast = head
 *      slow = head
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Move fast pointer N steps ahead:
 *
 *      for (i = 0 to N-1)
 *          fast = fast.next
 *
 * 2. If fast becomes null after N moves:
 *
 *      delete head node
 *
 * Because that means N is exactly equal to list length.
 *
 * 3. Otherwise move both pointers together:
 *
 *      while (fast.next != null)
 *
 *          fast = fast.next
 *          slow = slow.next
 *
 * 4. Now slow is just before the node to delete.
 *
 * 5. Delete node:
 *
 *      slow.next = slow.next.next
 *
 * --------------------------------------------------
 *
 * 🔹 Why while(fast.next != null)?
 *
 * We stop when fast reaches the last node.
 *
 * At that moment:
 *
 *      slow = node before target node
 *
 * So we can safely delete using:
 *
 *      slow.next = slow.next.next
 *
 * If we used:
 *
 *      while (fast != null)
 *
 * then slow would move one step extra
 * and point to the wrong node.
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 -> 2 -> 3 -> 4 -> 5
 *      N = 2
 *
 * Initially:
 *
 *      fast = 1
 *      slow = 1
 *
 * Move fast 2 steps:
 *
 *      fast = 3
 *
 * Move both:
 *
 *      fast = 4, slow = 2
 *      fast = 5, slow = 3
 *
 * Now fast.next == null
 *
 * slow is at 3
 *
 * Delete:
 *
 *      slow.next = slow.next.next
 *
 *      3.next = 5
 *
 * Final:
 *
 *      1 -> 2 -> 3 -> 5
 *
 * --------------------------------------------------
 *
 * 🔹 Edge Case:
 *
 * Example:
 *
 *      1 -> 2 -> 3 -> 4 -> 5
 *      N = 5
 *
 * After moving fast 5 steps:
 *
 *      fast = null
 *
 * Means delete first node:
 *
 *      head = head.next
 *
 * Final:
 *
 *      2 -> 3 -> 4 -> 5
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
 * "I move a fast pointer N steps ahead, then move both fast
 * and slow together. When fast reaches the end, slow is just
 * before the target node, allowing deletion in O(N) time and
 * O(1) space."
 */

