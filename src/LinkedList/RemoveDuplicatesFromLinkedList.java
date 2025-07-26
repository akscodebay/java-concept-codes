package LinkedList;

public class RemoveDuplicatesFromLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        head = new ListNode(0, head);
        ListNode prev = head;
        boolean flag = false;
        while(current!=null){
            while(current.next != null && current.val == current.next.val) {
                flag = true;
                current = current.next;
            }
            if(flag){
                prev.next = current.next;
                flag = false;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        RemoveDuplicatesFromLinkedList removeDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();

        ListNode start = removeDuplicatesFromLinkedList.deleteDuplicates(node1);
        while(start.next!=null){
            System.out.print(start.val+"->");
            start = start.next;
        }
        System.out.println(start.val);
    }
}
