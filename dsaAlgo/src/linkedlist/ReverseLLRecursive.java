package linkedlist;

public class ReverseLLRecursive {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next == null){
            return head;
        }
        else{
            ListNode call = reverseList(head.next);//always returns last element which becomes start element
            head.next.next = head;// call.next = head -- not possible
            head.next = null;
            return call;
        }
    }
}
