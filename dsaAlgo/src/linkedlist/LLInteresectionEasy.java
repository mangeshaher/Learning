package linkedlist;
/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.
*/
public class LLInteresectionEasy {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            if(a==null){
                a = headB;// We are making both pointers a and b reach same point dista + distb = distb + dista
            }
            else{
                a = a.next;
            }
            if(b==null){
                b = headA;// We are making both pointers a and b reach same point dista + distb = distb + dista
            }
            else{
                b = b.next;
            }
        }
        return a;
    }
}