public class optimalAlgo {
}

/**
 * 🎯 Sort Linked List Containing 0s, 1s and 2s Using Three Dummy Lists — Notes
 *
 * 🔹 Problem:
 * - Given a linked list containing only 0, 1 and 2
 * - Rearrange it so that:
 *      0s come first
 *      then 1s
 *      then 2s
 *
 * Example:
 *      Original:
 *      1 -> 0 -> 2 -> 1 -> 0 -> 2
 *
 *      Final:
 *      0 -> 0 -> 1 -> 1 -> 2 -> 2
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Create 3 separate chains:
 *      1. Zero List
 *      2. One List
 *      3. Two List
 *
 * - Traverse original list once
 * - Put each node into its correct chain
 * - Finally connect all three chains
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 *      zeroHead = new Node(-1)
 *      oneHead  = new Node(-1)
 *      twoHead  = new Node(-1)
 *
 *      zeroTail = zeroHead
 *      oneTail  = oneHead
 *      twoTail  = twoHead
 *
 *      current = head
 *
 * --------------------------------------------------
 *
 * 🔹 Why Dummy Nodes?
 * - Dummy nodes help avoid checking:
 *
 *      if list is empty
 *
 * - We can directly insert node at tail
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Traverse the linked list:
 *
 *      while (current != null)
 *
 * 2. If current.data == 0:
 *
 *      zeroTail.next = current
 *      zeroTail = zeroTail.next
 *
 * 3. Else if current.data == 1:
 *
 *      oneTail.next = current
 *      oneTail = oneTail.next
 *
 * 4. Else:
 *
 *      twoTail.next = current
 *      twoTail = twoTail.next
 *
 * 5. Move forward:
 *
 *      current = current.next
 *
 * 6. Connect lists:
 *
 *      zeroTail.next = (oneHead.next != null)
 *                       ? oneHead.next
 *                       : twoHead.next
 *
 *      oneTail.next = twoHead.next
 *
 *      twoTail.next = null
 *
 * 7. Update head:
 *
 *      head = zeroHead.next
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      1 -> 0 -> 2 -> 1 -> 0 -> 2
 *
 * After Traversal:
 *
 *      Zero List = 0 -> 0
 *      One List  = 1 -> 1
 *      Two List  = 2 -> 2
 *
 * After Connecting:
 *
 *      0 -> 0 -> 1 -> 1 -> 2 -> 2
 *
 * --------------------------------------------------
 *
 * 🔹 Important Condition:
 *
 *      zeroTail.next = (oneHead.next != null)
 *                       ? oneHead.next
 *                       : twoHead.next
 *
 * Why?
 * - If no 1 exists, directly connect 0-list to 2-list
 *
 * Example:
 *
 *      0 -> 2 -> 0 -> 2
 *
 * Final:
 *      0 -> 0 -> 2 -> 2
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
 * "I divide the linked list into separate 0, 1 and 2 chains
 * using dummy nodes and tail pointers, then connect them
 * together in O(N) time and O(1) space."
 */
