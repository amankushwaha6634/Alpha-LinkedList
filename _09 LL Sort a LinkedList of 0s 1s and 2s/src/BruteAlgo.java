public class BruteAlgo {
}

/**
 * 🎯 Sort Linked List Containing 0s, 1s and 2s Using Counting Method — Notes
 *
 * 🔹 Problem:
 * - Given a linked list containing only:
 *
 *      0, 1 and 2
 *
 * - Rearrange the linked list so that:
 *
 *      All 0s come first
 *      then all 1s
 *      then all 2s
 *
 * Example:
 *
 *      Original:
 *      1 -> 0 -> 2 -> 1 -> 0 -> 2
 *
 *      Final:
 *      0 -> 0 -> 1 -> 1 -> 2 -> 2
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Instead of moving nodes,
 *   count how many 0s, 1s and 2s are present.
 *
 * - Then traverse the linked list again
 *   and overwrite node values in sorted order.
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 *      count0 = number of 0s
 *      count1 = number of 1s
 *      count2 = number of 2s
 *
 *      current = head
 *
 * --------------------------------------------------
 *
 * 🔹 Step 1: Count Frequencies
 *
 * Traverse the linked list once:
 *
 *      while (current != null)
 *
 * If current.data == 0:
 *      count0++
 *
 * Else if current.data == 1:
 *      count1++
 *
 * Else:
 *      count2++
 *
 * --------------------------------------------------
 *
 * Example:
 *
 *      1 -> 0 -> 2 -> 1 -> 0 -> 2
 *
 * After counting:
 *
 *      count0 = 2
 *      count1 = 2
 *      count2 = 2
 *
 * --------------------------------------------------
 *
 * 🔹 Step 2: Rewrite Linked List
 *
 * Again start from head:
 *
 *      current = head
 *
 * Traverse until current becomes null.
 *
 * If count0 > 0:
 *
 *      current.data = 0
 *      count0--
 *
 * Else if count1 > 0:
 *
 *      current.data = 1
 *      count1--
 *
 * Else:
 *
 *      current.data = 2
 *      count2--
 *
 * Then move:
 *
 *      current = current.next
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 * Original:
 *
 *      1 -> 0 -> 2 -> 1 -> 0 -> 2
 *
 * After Counting:
 *
 *      count0 = 2
 *      count1 = 2
 *      count2 = 2
 *
 * Rewriting:
 *
 *      Node 1 becomes 0
 *      Node 2 becomes 0
 *      Node 3 becomes 1
 *      Node 4 becomes 1
 *      Node 5 becomes 2
 *      Node 6 becomes 2
 *
 * Final:
 *
 *      0 -> 0 -> 1 -> 1 -> 2 -> 2
 *
 * --------------------------------------------------
 *
 * 🔹 Why Is It Called Bruteforce?
 * - Because we traverse the linked list twice
 *
 *      First Pass  -> Count values
 *      Second Pass -> Rewrite values
 *
 * - We are not rearranging nodes
 * - We are simply changing their data
 *
 * --------------------------------------------------
 *
 * 🔹 Important Edge Cases:
 *
 * Case 1:
 *      List is empty
 *
 *      head == null
 *
 *      Return immediately
 *
 * Case 2:
 *      Only one node
 *
 *      1
 *
 *      Already sorted
 *
 * Case 3:
 *      Only one type exists
 *
 *      2 -> 2 -> 2
 *
 *      Final remains same
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * Let:
 *      N = number of nodes
 *
 * First pass  = O(N)
 * Second pass = O(N)
 *
 * 👉 Total Time Complexity = O(2N) ≈ O(N)
 *
 * 👉 Space Complexity = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 * - Count first
 * - Rewrite later
 * - No need to move nodes physically
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 * "I first count the number of 0s, 1s and 2s in one traversal,
 * then overwrite the linked list values in sorted order during
 * the second traversal, achieving O(N) time and O(1) space."
 */
