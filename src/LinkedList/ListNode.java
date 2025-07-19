package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode rand;
    ListNode(int x){
        this.val = x;
        this.next = null;
        this.rand = null;
    }

    ListNode(int x, ListNode next){
        this.val = x;
        this.next = next;
        this.rand = null;
    }
}
