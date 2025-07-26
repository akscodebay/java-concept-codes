package LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node next;
    Node prev;
    Integer key;
    Integer val;

    Node(Integer key, Integer val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

public class LRUCache {
    private final Map<Integer, Node> map;
    private final Integer capacity;
    private Node head = new Node(-1,-1, null, null);
    private Node tail = new Node(-1,-1,null,null);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.remove(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        else if(!(map.size()<capacity)){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node node = new Node(key, value, tail.prev, tail);
        tail.prev.next = node;
        tail.prev = node;
        map.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));
    }
}
