//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x){
//        this.val = x;
//        this.next = null;
//    }
//}
public class LinkedListAddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        int carry = 0;
        while(l1.next!=null && l2.next!=null){
            l1.val = l1.val + l2.val + carry;
            carry = l1.val/10;
            l1.val = l1.val%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.val = l1.val + l2.val + carry;
        carry = l1.val/10;
        l1.val = l1.val%10;

        if(l1.next==null && l2.next==null) {
            if (carry > 0)
                l1.next = new ListNode(carry);
            return result;
        }
        if(l2.next!=null){
            l1.next = l2.next;
        }
        l1 = l1.next;
        while(l1.next!=null){
            l1.val+=carry;
            carry = l1.val/10;
            l1.val = l1.val%10;
            l1 = l1.next;
        }
        l1.val = l1.val + carry;
        carry = l1.val/10;
        l1.val = l1.val%10;
        if(carry>0)
            l1.next = new ListNode(carry);
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;

        LinkedListAddTwoNumbers listAddTwoNumbers = new LinkedListAddTwoNumbers();
        ListNode result = listAddTwoNumbers.addTwoNumbers(l1, l2);
        while(result!=null){
            System.out.println(result.val+" ");
            result = result.next;
        }
    }
}
