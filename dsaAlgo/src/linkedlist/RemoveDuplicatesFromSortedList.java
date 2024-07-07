package linkedlist;

/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]
Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode n = head;
        while(n!=null && n.next!=null){
            ListNode nextDistinct = n.next;
            while(nextDistinct!=null && nextDistinct.val == n.val){
                nextDistinct = nextDistinct.next;
            }
            n.next = nextDistinct;
            n=n.next;
        }
        return head;
    }
}
