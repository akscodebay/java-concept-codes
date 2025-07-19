package LinkedList;

public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode previous = new ListNode(-1);
        ListNode head = previous;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                previous.next = list2;
                previous = list2;
                list2 = list2.next;
            } else {
                previous.next = list1;
                previous = list1;
                list1 = list1.next;
            }
        }
        if (list1 != null)
            while (list1 != null) {
                previous.next = list1;
                previous = list1;
                list1 = list1.next;
            }
        if (list2 != null)
            while (list2 != null) {
                previous.next = list2;
                previous = list2;
                list2 = list2.next;
            }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
        ListNode result = mergeTwoSortedLinkedList.mergeTwoLists(l1, l2);
        while(result.next!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.println(result.val);
    }
}
