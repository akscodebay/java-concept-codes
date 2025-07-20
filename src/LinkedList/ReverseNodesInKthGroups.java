package LinkedList;

public class ReverseNodesInKthGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null  || k==1){
            return head;
        }
        ListNode frontAttach = null;
        ListNode reverseHead = new ListNode(0, head);
        ListNode pointer = head;
        int i=1;
        while (pointer.next!=null) {
            if(i==k){
                frontAttach = reverseHead;
                reverseHead = pointer;
                i=0;
            }
            pointer = pointer.next;
            i++;
        }
        if(i==k){
            frontAttach = reverseHead;
            reverseHead = reverseHead.next;
        }
        else {
            if(frontAttach!=null) {
                    reverseHead = frontAttach.next;
            }
        }
        ListNode prev = null;
        ListNode attachEnd = reverseHead;
        while(k>0){
            ListNode temp = reverseHead;
            reverseHead = reverseHead.next;
            temp.next = prev;
            prev = temp;
            k--;
        }
        if(frontAttach!=null && frontAttach.next!=head){
            frontAttach.next = prev;
        }
        else {
            head = prev;
        }
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

        ReverseNodesInKthGroups reverseNodesInKthGroups = new ReverseNodesInKthGroups();
        ListNode reversedList = reverseNodesInKthGroups.reverseKGroup(node1, 2);
        while(reversedList.next!=null){
            System.out.print(reversedList.val+"->");
            reversedList = reversedList.next;
        }
        System.out.println(reversedList.val);
    }
}
