package Medium.interview0204;

import Medium.num143.ListNode;

public class Solution {
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ListNode smallDummy = new ListNode(1);
    ListNode bigDummy = new ListNode(1);
    ListNode smallTemp = smallDummy;
    ListNode bigTemp = bigDummy;
    while (head != null) {
      ListNode next = head.next;
      if (head.val < x) {
        smallTemp.next = head;
        smallTemp = smallTemp.next;
      } else {
        bigTemp.next = head;
        bigTemp = bigTemp.next;
      }
      head.next = null;
      head = next;
    }
    smallTemp.next = bigDummy.next;
    return smallDummy.next;
  }
}
