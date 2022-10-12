package medium.num146;

import java.util.HashMap;
import java.util.Map;

/**
 ["LRUCache","put","put","put","put","get","get"]
 [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
 **/
public class LRUCache {
  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(2, 1);
    lruCache.put(1, 1);
    lruCache.put(2, 3);
    lruCache.put(3, 1);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(2));
//    lruCache.put(1, 5);
//    lruCache.put(1, 2);
//    System.out.println(lruCache.get(2));
  }


  private final Map<Integer, ListNode> map;
  private int size;
  private final int capacity;
  private final ListNode first;
  private final ListNode tail;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    size = 0;
    this.capacity = capacity;
    first = new ListNode(0, 0);
    tail = new ListNode(0, 0);
    first.next = tail;
    tail.pre = first;
  }

  public int get(int key) {
    // 如果有 要挪到链表头
    if (map.get(key) == null) {
      return -1;
    }
    ListNode node = map.get(key);
    node.pre.next = node.next;
    node.next.pre = node.pre;
    node.pre = first;
    node.next = first.next;
    first.next.pre = node;
    first.next = node;
    return node.val;
  }

  public void put(int key, int value) {
    if (size == capacity && !map.containsKey(key)) {
      ListNode temp = tail.pre;
      temp.pre.next = tail;
      tail.pre = temp.pre;
      map.remove(temp.key);
      size--;
    }
    if (!map.containsKey(key)) {
      size++;
    }
    // 是否已在map里
    ListNode node;
    if (map.get(key) != null) {
      node = map.get(key);
      node.val = value;
      node.pre.next = node.next;
      node.next.pre = node.pre;
    } else {
      node = new ListNode(key, value);
      map.put(key, node);
    }
    node.pre = first;
    node.next = first.next;
    first.next.pre = node;
    first.next = node;
  }

  public static class ListNode {
    private Integer key;
    private Integer val;
    private ListNode pre;
    private ListNode next;

    public ListNode() {}

    public ListNode(Integer key, Integer val) {
      this.key = key;
      this.val = val;
    }
  }
}
