package linkedlist;
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

Follow up: Could you do this in one pass?
*/
public class RemoveNthFromEndLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = n;
        ListNode fast = head;
        while(fast!=null && count!=0){
            fast = fast.next;
            count--;
        }
        if(fast==null){
            return head.next;
        }
        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode toDelete = slow.next;
        ListNode next = toDelete.next;
        slow.next = next;
        toDelete.next = null;
        return head;
    }
}
