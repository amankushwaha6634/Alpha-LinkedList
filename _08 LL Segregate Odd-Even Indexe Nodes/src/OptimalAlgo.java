public class OptimalAlgo {
}

/**
 * 🎯 Segregate Odd and Even Position Nodes In-Place — Notes
 *
 * 🔹 Problem:
 * - Rearrange linked list so that:
 *      1. All odd-position nodes come first
 *      2. Then all even-position nodes
 *
 * - Position is 1-based
 *
 * Example:
 *      Original:
 *      1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
 *
 *      Odd Position Nodes:
 *      1 -> 3 -> 5 -> 7
 *
 *      Even Position Nodes:
 *      2 -> 4 -> 6
 *
 *      Final:
 *      1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Maintain two separate chains:
 *      1. Odd-position nodes
 *      2. Even-position nodes
 *
 * - Traverse list once
 * - Reconnect pointers in-place
 * - Finally connect odd list with even list
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 * - odd      → points to current odd-position node
 * - even     → points to current even-position node
 * - evenHead → stores first even node
 *
 * Example Initially:
 *
 *      odd = 1
 *      even = 2
 *      evenHead = 2
 *
 * --------------------------------------------------
 *
 * 🔹 Why evenHead?
 * - During traversal, even pointer moves ahead
 * - We would lose the starting node of even list
 * - So we save it in evenHead
 *
 * Final Step:
 *
 *      odd.next = evenHead
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. If list is empty or has one node:
 *
 *      return
 *
 * 2. Initialize:
 *
 *      odd = head
 *      even = head.next
 *      evenHead = head.next
 *
 * 3. Traverse while:
 *
 *      even != null && even.next != null
 *
 * 4. Connect odd node to next odd node:
 *
 *      odd.next = odd.next.next
 *
 * 5. Move odd pointer:
 *
 *      odd = odd.next
 *
 * 6. Connect even node to next even node:
 *
 *      even.next = even.next.next
 *
 * 7. Move even pointer:
 *
 *      even = even.next
 *
 * 8. After loop, connect:
 *
 *      odd.next = evenHead
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 * Original:
 *      1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
 *
 * Initially:
 *      odd = 1
 *      even = 2
 *
 * Iteration 1:
 *      odd.next = 3
 *      even.next = 4
 *
 *      odd = 3
 *      even = 4
 *
 * Iteration 2:
 *      odd.next = 5
 *      even.next = 6
 *
 *      odd = 5
 *      even = 6
 *
 * Iteration 3:
 *      odd.next = 7
 *      even.next = null
 *
 *      odd = 7
 *      even = null
 *
 * Loop Ends
 *
 * Final Connection:
 *      7.next = 2
 *
 * Final List:
 *      1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6
 *
 * --------------------------------------------------
 *
 * 🔹 Important Observation:
 *
 * Case 1: Odd Number of Nodes
 *
 *      1 -> 2 -> 3 -> 4 -> 5
 *
 *      Final:
 *          odd = 5
 *          even = null
 *
 * Case 2: Even Number of Nodes
 *
 *      1 -> 2 -> 3 -> 4 -> 5 -> 6
 *
 *      Final:
 *          odd = 5
 *          even = 6
 *          even.next = null
 *
 * Therefore loop condition:
 *
 *      while (even != null && even.next != null)
 *
 * safely handles both cases
 *
 * --------------------------------------------------
 *
 * 🔹 Why In-Place?
 * - No extra array
 * - No extra linked list
 * - Only pointers are modified
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * Let:
 *      N = number of nodes
 *
 * - Each node is visited once
 *
 * 👉 Time Complexity = O(N)
 *
 * - No extra space used
 *
 * 👉 Space Complexity = O(1)
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 * - Separate odd and even nodes while traversing
 * - Save starting point of even list
 * - Attach even list after odd list at the end
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 * "I maintain separate odd and even chains using two pointers,
 * reconnect nodes in-place, and finally attach the even chain
 * after the odd chain, achieving O(N) time and O(1) space."
 */