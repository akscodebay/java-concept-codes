package LinkedList;

public class ReverseLinkedList {
    public ListNode head;
    public int reverse(ListNode node) {
        if(node.next==null){
            head = node;
            return 0;
        }
        reverse(node.next);
        node.next.next = node;
        return 0;
    }

    public ListNode reversewithLoop(ListNode node){
        if(node==null){
            return node;
        }
        ListNode prev = null;
        while(node.next!=null){
            ListNode temp = node;
            node = node.next;
            temp.next = prev;
            prev = temp;
        }
        node.next = prev;
        return node;
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
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverse(node1);
        node1.next = null;
        ListNode listNode = reverseLinkedList.head;
        while(reverseLinkedList.head.next!=null){
            System.out.print(reverseLinkedList.head.val+"->");
            reverseLinkedList.head = reverseLinkedList.head.next;
        }
        System.out.println(reverseLinkedList.head.val);

        ListNode start = reverseLinkedList.reversewithLoop(listNode);
        while(start.next!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println(start.val);
    }
}
