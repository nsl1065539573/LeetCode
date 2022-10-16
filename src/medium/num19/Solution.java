package medium.num19;

import datastruct.ListNode;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    ListNode slow = dummy;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
}
