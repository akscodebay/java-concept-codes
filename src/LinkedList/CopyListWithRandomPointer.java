package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public ListNode copyRandomList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode mapListNode = head;
        Map<ListNode, ListNode> hashMap = new HashMap<>();
        while(mapListNode!=null) {
            if(mapListNode.rand!=null && !hashMap.containsKey(mapListNode.rand)){
                hashMap.put(mapListNode.rand, new ListNode(mapListNode.rand.val));
            }
            mapListNode = mapListNode.next;
        }
        mapListNode = head;
        ListNode newLinkedList = !hashMap.containsKey(mapListNode)?new ListNode(mapListNode.val):hashMap.get(mapListNode);
        ListNode pointer = newLinkedList;
        while(mapListNode.next!=null){
            if(hashMap.containsKey(mapListNode.next)){
                pointer.next = hashMap.get(mapListNode.next);
            }else {
                pointer.next = new ListNode(mapListNode.next.val);
            }
            if(hashMap.containsKey(mapListNode.rand)){
               pointer.rand = hashMap.get(mapListNode.rand);
            }

            pointer = pointer.next;
            mapListNode = mapListNode.next;
        }
        if(hashMap.containsKey(mapListNode.rand)){
            pointer.rand = hashMap.get(mapListNode.rand);
        }
        return newLinkedList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(13);
        ListNode l3 = new ListNode(11);
        ListNode l4 = new ListNode(10);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        l2.rand = l1;
        l3.rand = l5;
        l4.rand = l2;
        l5.rand = l1;

        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        ListNode copyLinkedList = copyListWithRandomPointer.copyRandomList(l1);
        System.out.println(copyLinkedList);
    }
}
