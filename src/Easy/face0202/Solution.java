package Easy.face0202;

import Easy.dataStruct.ListNode;

public class Solution {
  public int kthToLast(ListNode head, int k) {
    ListNode fast = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    ListNode slow = head;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow.val;
  }
}
