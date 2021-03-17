package demo01.deWeight;

import Easy.dataStruct.ListNode;

import java.util.HashSet;

public class Solution {
  public static void main(String[] args) {
    ListNode head = new ListNode(5);
    ListNode node = new ListNode(5);
    ListNode node1 = new ListNode(4);
    head.next = node;
    node.next = node1;
    list(head);
    domain(head);
    list(head);
  }

  public static void list(ListNode node) {
    while (node != null) {
      System.out.print(node.val + "->");
      node = node.next;
    }
    System.out.println();
  }

  public static void domain(ListNode head) {
    HashSet<Integer> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head.val)) {
        if (head.next != null) {
          head.val = head.next.val;
          head.next = head.next.next;
        } else {
          head = null;
        }
      } else {
        set.add(head.val);
      }
      if (head != null) {
        head = head.next;
      }
    }
  }
}
