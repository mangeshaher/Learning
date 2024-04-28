package kmergeheap;

import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
*/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode retval;
        ListNode start = null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode n : lists){
            if(n!=null){
                q.offer(n);
            }
        }
        if(q.size() != 0){
            start = q.poll();
        }
        retval = start;
        while(q.size() != 0){
            if(start.next != null){
                q.offer(start.next);
            }
            ListNode temp = q.poll();
            if(start!=null){
                start.next = temp;
            }
            start = temp;
        }
        return retval;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}