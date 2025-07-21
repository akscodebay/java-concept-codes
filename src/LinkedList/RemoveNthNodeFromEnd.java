package LinkedList;

public class RemoveNthNodeFromEnd {
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        head.next = removeNthFromEnd(head.next, n);
        count++;
        if(n == count){
            head = head.next;
        }
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

        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode start = removeNthNodeFromEnd.removeNthFromEnd(node1, 4);
        while(start.next!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println(start.val);
    }
}
