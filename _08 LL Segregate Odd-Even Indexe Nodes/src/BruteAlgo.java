public class BruteAlgo {
}
/**
 * 🎯 Segregate Odd and Even Indexed Nodes Using One Extra Array — Notes
 *
 * 🔹 Problem:
 * - Rearrange linked list so that:
 *      1. All odd-indexed nodes come first
 *      2. Then all even-indexed nodes
 *
 * - Indexing is 0-based
 *
 * Example:
 *      Original:
 *      0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 50
 *
 *      Odd indices:
 *      1 -> 3 -> 5
 *
 *      Even indices:
 *      0 -> 2 -> 4 -> 50
 *
 *      Final:
 *      1 -> 3 -> 5 -> 0 -> 2 -> 4 -> 50
 *
 * --------------------------------------------------
 *
 * 🔹 Core Idea:
 * - Use only one extra array
 * - First store all odd-indexed node values
 * - Then store all even-indexed node values
 * - Rewrite linked list using array values
 *
 * --------------------------------------------------
 *
 * 🔹 Why One Array?
 * - Previous approach used:
 *      oddArray + evenArray
 *
 * - Here we use:
 *      only one array
 *
 * - Saves extra space for second array
 *
 * --------------------------------------------------
 *
 * 🔹 Steps:
 *
 * 1. Create one array:
 *
 *      List<Integer> arr = new ArrayList<>();
 *
 * 2. Traverse linked list first time
 *    - If index is odd:
 *          arr.add(current.data)
 *
 * 3. Traverse linked list second time
 *    - If index is even:
 *          arr.add(current.data)
 *
 * 4. Traverse linked list third time
 *    - Replace node values using array
 *
 * --------------------------------------------------
 *
 * 🔹 Dry Run:
 *
 * Original List:
 *      0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 50
 *
 * First Traversal:
 *      Store odd-indexed elements
 *
 *      Index 1 -> 1
 *      Index 3 -> 3
 *      Index 5 -> 5
 *
 *      arr = [1, 3, 5]
 *
 * Second Traversal:
 *      Store even-indexed elements
 *
 *      Index 0 -> 0
 *      Index 2 -> 2
 *      Index 4 -> 4
 *      Index 6 -> 50
 *
 *      arr = [1, 3, 5, 0, 2, 4, 50]
 *
 * Third Traversal:
 *      Rewrite linked list
 *
 *      Final List:
 *      1 -> 3 -> 5 -> 0 -> 2 -> 4 -> 50
 *
 * --------------------------------------------------
 *
 * 🔹 Variables Used:
 *
 * - current → used to traverse linked list
 * - index   → stores current node index
 * - arr     → single array storing final order
 * - i       → used while rewriting linked list
 *
 * --------------------------------------------------
 *
 * 🔹 Complexity:
 *
 * Let:
 *      N = number of nodes in linked list
 *
 * - First traversal  = O(N)
 * - Second traversal = O(N)
 * - Third traversal  = O(N)
 *
 * 👉 Time Complexity = O(N)
 *
 * - One extra array of size N is used
 *
 * 👉 Space Complexity = O(N)
 *
 * --------------------------------------------------
 *
 * 🔹 Key Insight:
 * - Do not create two separate arrays
 * - Store odd-indexed values first and even-indexed values later
 * - Then overwrite linked list in same order
 *
 * --------------------------------------------------
 *
 * 🔹 Interview Line:
 * "I use one extra array to first collect odd-indexed nodes,
 * then even-indexed nodes, and finally rewrite the linked list,
 * achieving O(N) time and O(N) space."
 */