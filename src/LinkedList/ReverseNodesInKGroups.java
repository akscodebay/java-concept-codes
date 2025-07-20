package LinkedList;

public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null  || k==1){
            return head;
        }
        ListNode reverseHead = head;
        ListNode pointer = head;
        ListNode result = null;
        int i=1;
        while (pointer!=null) {
            if (i == k) {
                ListNode nextHead = head.next;
                int n = k;
                ListNode prev = null;
                ListNode attachEnd = reverseHead;
                while (n > 0) {
                    ListNode temp = reverseHead;
                    reverseHead = reverseHead.next;
                    temp.next = prev;
                    prev = temp;
                    n--;
                }
                if(result == null) {
                    result = prev;
                } else {
                    head.next = prev;
                    head = nextHead;
                }
                attachEnd.next = reverseHead;
                pointer = attachEnd;
                i = 0;
            }
            pointer = pointer.next;
            i++;
        }
        return result;
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

        ReverseNodesInKGroups reverseNodesInKGroups = new ReverseNodesInKGroups();
        ListNode reversedList = reverseNodesInKGroups.reverseKGroup(node1, 3);
        while(reversedList.next!=null){
            System.out.print(reversedList.val+"->");
            reversedList = reversedList.next;
        }
        System.out.println(reversedList.val);
    }
}
