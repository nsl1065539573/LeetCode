package Easy.Offer52;

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode node1 = headA;
    ListNode node2 = headB;
    while (node1 != node2) {
      node1 = node1 == null ? headB : node1.next;
      node2 = node2 == null ? headA : node2.next;
    }
    return node1;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
