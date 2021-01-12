package nowCode.easy.NC78;

public class Solution {
  public ListNode ReverseList(ListNode head) {
    ListNode dummy = new ListNode(0);
    while (head != null) {
      ListNode next = head.next;
      head.next = dummy.next;
      dummy.next = head;
      head = next;
    }
    return dummy.next;
  }
}

class ListNode {
  int val;
  ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }
}