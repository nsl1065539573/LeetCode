package Hard.num23;

import Easy.dataStruct.ListNode;

public class Solution {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    ListNode l4 = new ListNode(1);
    ListNode l5 = new ListNode(3);
    ListNode l6 = new ListNode(4);
    l4.next = l5;
    l5.next = l6;
    ListNode l7 = new ListNode(2);
    l7.next = new ListNode(6);
    ListNode[] arr = new ListNode[3];
    arr[0] = l1;
    arr[1] = l4;
    arr[2] = l7;
    Solution solution = new Solution();
    solution.mergeKLists(arr);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    ListNode res = lists[0];
    for (int i = 1; i < lists.length; i++) {
      res = merge(res, lists[i]);
    }
    return res;
  }

  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode temp = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    while (l1 != null) {
      temp.next = l1;
      l1 = l1.next;
      temp = temp.next;
    }
    while (l2 != null) {
      temp.next = l2;
      l2 = l2.next;
      temp = temp.next;
    }
    return dummy.next;
  }
}
