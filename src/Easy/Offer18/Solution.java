package Easy.Offer18;

public class Solution {
  public ListNode deleteNode(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode temp = dummy;
    while (temp.next != null) {
      if (temp.next.val == val) {
        temp.next = temp.next.next;
        return dummy.next;
      }
      temp = temp.next;
    }
    return dummy.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
