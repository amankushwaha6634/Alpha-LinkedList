
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

/**
How do we think of the 2-pointer solution?

Suppose we want to delete the Nth node from the end.

Brute force idea:
1. Find length of list
2. Target position from start = length - N + 1
3. Traverse again and delete

This takes 2 traversals.

Then we think:
Can we do it in 1 traversal?

We need one pointer to somehow know when we are N nodes away from the end.

So we use two pointers.

Idea:
- fast moves first
- slow starts later

If fast is always N nodes ahead of slow, then:

When fast reaches the end,
slow will automatically be N nodes behind the end.

And N nodes behind the end means:
slow is just before the node we want to delete.

Example:

    1 -> 2 -> 3 -> 4 -> 5
    N = 2

We want to delete 4.

So first create distance of 2:

    slow = 1
    fast = 3

Now move both together:

    slow = 2, fast = 4
    slow = 3, fast = 5

Fast reached end.

Since gap was always 2,
slow is exactly before the 2nd node from end.

That is why we move fast ahead first.

The 2-pointer trick is generally used whenever:
- We want one pointer to "follow" another
- We want fixed distance between two pointers
- We want to solve something in one traversal
*/


/**
It may look like fast moves N + 1 steps, but actually initial gap is exactly N.

Example:

    1 -> 2 -> 3 -> 4 -> 5
    N = 2

After moving fast N times:

    slow = 1
    fast = 3

Gap = 2 nodes
Q Why do we call this a gap of 2?
 Because fast is 2 moves ahead of slow:
 A. 1 --(1 step)--> 2 --(2 step)--> 3

Now both move together:

    slow = 2
    fast = 4

    slow = 3
    fast = 5

We stop because:

    fast.next == null

So fast does NOT move one extra step beyond 5.

At this moment:

    slow = 3
    slow.next = 4

which is exactly the node we want to delete.

Why not use while(fast != null)?

Because then fast would move one extra step to null:

    slow = 4
    fast = null

Now slow itself is at the node to delete,
not before it, so deletion becomes harder.

Therefore:

    Move fast exactly N steps first
    Then stop loop at fast.next != null

This keeps slow exactly one node before target.
*/


/*
We stop when fast reaches the last node (not null)
because we want slow to remain one node before the target node.

Example:

    1 -> 2 -> 3 -> 4 -> 5
    N = 2

After moving fast 2 steps:

    slow = 1
    fast = 3

Now move both until:

    fast.next == null

Step 1:
    slow = 2
    fast = 4

Step 2:
    slow = 3
    fast = 5

Now fast is at last node.

So slow is at 3,
which is exactly before the node we want to delete (4).

Then we can do:

    slow.next = slow.next.next

------------------------------------------------

If instead we keep moving until:

    fast == null

Then one extra move happens:

    slow = 4
    fast = null

Now slow itself is on the node to delete.

But to delete a node in singly linked list,
we need the previous node, not the node itself.

Because deletion is done by changing previous.next:

    previous.next = previous.next.next

So we intentionally stop early,
when fast is at last node,
so slow stays one step behind target.
*/