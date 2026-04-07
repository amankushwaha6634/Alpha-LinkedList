public class Algo {
}
/**
 * 🎯 Add Two Numbers Using Linked List — Notes
 ******************************************************
 *
 *     Important:
 *     - Digits are stored in reverse order
 *     - Head contains least significant digit
 *
 *     Example:
 *         Number = 987
 *
 *         Linked List:
 *         7 -> 8 -> 9
 *
 *     So while traversing:
 *         first node  = units place
 *         second node = tens place
 *         third node  = hundreds place
 *********************************************************

 * 🔹 Problem:
 * - Two linked lists are given
 * - Each node contains one digit
 * - We need to add both numbers and return result as a new linked list
 *
 * Example:
 *      l1 = 3 -> 8 -> 7
 *      l2 = 5 -> 4 -> 4 -> 9
 *
 * Result:
 *      8 -> 2 -> 2 -> 0 -> 1
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Traverse both linked lists together
 * - Add corresponding digits
 * - Maintain carry
 * - Store digit in a new linked list
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 * - p1      → pointer for first linked list
 * - p2      → pointer for second linked list
 * - carry   → stores carry generated during addition
 * - sum     → current sum of digits + carry
 * - dummy   → temporary starting node for result list
 * - current → pointer used to build answer list
 *
 * --------------------------------------------------
 *
 * 🔹 Why Dummy Node?
 *
 * - Makes insertion easy
 * - Avoids separate handling of first node
 * - Prevents losing head of result list
 *
 * Example:
 *
 *      dummy -> null
 *
 * After insertion:
 *
 *      0 -> 8 -> 2 -> 2 -> 0 -> 1
 *
 * Final answer starts from:
 *
 *      dummy.next
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Create two pointers:
 *      p1 = l1.head
 *      p2 = l2.head
 *
 * 2. Create:
 *      dummy node
 *      current pointer
 *      carry = 0
 *
 * 3. Traverse while at least one list has node:
 *
 *      while (p1 != null || p2 != null)
 *
 * 4. Start sum with previous carry:
 *
 *      sum = carry
 *
 * 5. If p1 exists:
 *      add p1.data
 *      move p1 forward
 *
 * 6. If p2 exists:
 *      add p2.data
 *      move p2 forward
 *
 * 7. Find carry:
 *
 *      carry = sum / 10
 *
 * 8. Find digit to store:
 *
 *      digit = sum % 10
 *
 * 9. Create node with digit and attach to result list
 *
 * 10. Move current forward
 *
 * 11. After loop:
 *      If carry > 0
 *      Add one more node
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 *      l1 = 3 -> 8 -> 7
 *      l2 = 5 -> 4 -> 4 -> 9
 *
 * Iteration 1:
 *      3 + 5 + 0 = 8
 *      digit = 8
 *      carry = 0
 *
 * Result:
 *      8
 *
 * Iteration 2:
 *      8 + 4 + 0 = 12
 *      digit = 2
 *      carry = 1
 *
 * Result:
 *      8 -> 2
 *
 * Iteration 3:
 *      7 + 4 + 1 = 12
 *      digit = 2
 *      carry = 1
 *
 * Result:
 *      8 -> 2 -> 2
 *
 * Iteration 4:
 *      0 + 9 + 1 = 10
 *      digit = 0
 *      carry = 1
 *
 * Result:
 *      8 -> 2 -> 2 -> 0
 *
 * Remaining Carry:
 *      1
 *
 * Final Result:
 *      8 -> 2 -> 2 -> 0 -> 1
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * Let:
 *      m = size of first linked list
 *      n = size of second linked list
 *
 * - We traverse both lists once
 *
 * 👉 Time Complexity = O(max(m, n))
 *
 * - New linked list is created
 *
 * 👉 Space Complexity = O(max(m, n))
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 * - Traverse both lists together
 * - Keep carry at every step
 * - Use dummy node to simplify insertion
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 * "I traverse both linked lists simultaneously, add corresponding
 * digits with carry, and use a dummy node to build the result list
 * in O(max(m, n)) time."
 */