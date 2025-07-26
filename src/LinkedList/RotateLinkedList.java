package LinkedList;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode end = head;
        ListNode start = head;
        int totalCount = 0;
        while(end.next!=null){
            totalCount++;
            end = end.next;
        }
        totalCount++;
        k = k%totalCount;
        k = totalCount-k;

        if(k==0)
            return head;
        while(k>1){
            k--;
            start = start.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode start = new RotateLinkedList().rotateRight(node1, 2);
        while(start.next!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println(start.val);
    }
}
