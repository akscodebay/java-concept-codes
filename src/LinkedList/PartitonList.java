package LinkedList;

public class PartitonList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(0);
        ListNode bigList = new ListNode(0);
        ListNode sPointer = smallList;
        ListNode bPointer = bigList;
        while(head!=null){
            if (head.val<x){
                sPointer.next = head;
                sPointer = sPointer.next;
            } else {
                bPointer.next = head;
                bPointer = bPointer.next;
            }
            head = head.next;
        }
        sPointer.next = bigList.next;
        bPointer.next = null;
        return smallList.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode start = new PartitonList().partition(node1, 3);
        while(start.next!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println(start.val);
    }
}
