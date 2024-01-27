package linkedlist;

public class MergeSortedLLIterativeMedium {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode(0, null);
        ListNode l2 = list2;
        ListNode l1 = list1;
        ListNode retval = start;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                start.next = l1;
                l1 = l1.next;
                start = start.next;
            }
            else if(l1.val > l2.val){
                start.next = l2;
                l2 = l2.next;
                start = start.next;
            }
            else{
                start.next = l1;
                l1 = l1.next;
                start = start.next;
                start.next = l2;
                l2 = l2.next;
                start = start.next;
            }
        }
        if(l1!=null){
            start.next = l1;
        }
        if(l2!=null){
            start.next = l2;
        }
        return retval.next;
    }
}
