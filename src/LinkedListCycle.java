
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        this.next = null;
    }
}
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;

        while(fastPointer!=null && fastPointer.next!=null){
            head = head.next;
            fastPointer = fastPointer.next.next;
            if(head == fastPointer)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode2;

        System.out.println(linkedListCycle.hasCycle(listNode1));
    }
}
