package LinkedList;

public class LinkedListReverseSubList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }
        ListNode reverseHead = head;
        ListNode attachFront = null;
        int i = 1;
        while(reverseHead.next!=null && i<left) {
            attachFront = reverseHead;
            reverseHead = reverseHead.next;
            i++;
        }
        ListNode prev = null;
        ListNode attachEnd = reverseHead;
        while(left<=right){
            ListNode temp = reverseHead;
            reverseHead = reverseHead.next;
            temp.next = prev;
            prev = temp;
            left++;
        }
        if(attachFront!=null)
            attachFront.next = prev;
        else
            head = prev;
        attachEnd.next = reverseHead;
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

        LinkedListReverseSubList linkedListReverseSubList = new LinkedListReverseSubList();
        ListNode reversedList = linkedListReverseSubList.reverseBetween(node1, 2, 4);
        while(reversedList.next!=null){
            System.out.print(reversedList.val+"->");
            reversedList = reversedList.next;
        }
        System.out.println(reversedList.val);
    }
}
