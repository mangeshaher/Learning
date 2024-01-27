package linkedlist;

public class LLPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        if(fast == null){
            return true;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }//reach till midpoint
        if(fast.next==null){
            ListNode sHalf = slow.next;
            slow.next = null;
            ListNode fHalf = reverseList(head);//reverse first half till mid
            return isMatch(fHalf, sHalf);
        }
        else{
            ListNode sHalf = slow.next.next;
            slow.next = null;
            ListNode fHalf = reverseList(head);//reverse first half till mid
            return isMatch(fHalf, sHalf);
        }
    }

    public boolean isMatch(ListNode f, ListNode s) {
        while(f!=null && s!=null){
            if(f.val!=s.val){
                return false;
            }
            f=f.next;
            s=s.next;
        }
        return true;
    }

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
