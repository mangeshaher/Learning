package linkedlist;

public class ReverseLLIterative {
    public ListNode reverseList(ListNode head) {
        if(head!=null && head.next!=null){
            ListNode start = head;
            ListNode sstart = head.next;
            start.next = null;
            while(sstart!=null){
                ListNode snext = sstart.next;
                sstart.next = start;
                start = sstart;
                sstart = snext;
            }
            return start;
        }
        else{
            return head;
        }
    }
}
