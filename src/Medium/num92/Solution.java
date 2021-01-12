package Medium.num92;

import demo01.linkedListDemo.Main;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    ListNode node = solution.reverseBetween(node1, 2, 4);
    Solution.list(node);
  }

  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == 1) {
      return reverseN(head, n);
    }
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
  }

  ListNode next = null;

  ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
      this.next = head.next;
      return head;
    }
    ListNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = this.next;
    return last;
  }

  public static void list(ListNode node) {
    while (node != null) {
      System.out.print(node.val + "->");
      node = node.next;
    }
  }

}

class ListNode {
  int val;
  ListNode next;
  ListNode(int val) { this.val = val; }
}