package Medium.num143;


public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 双指针找到链表中间结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = slow.next;
        slow.next = null;
        // 翻转第二个链表
        ListNode tempHead = new ListNode(0);
        while (head1 != null) {
            ListNode temp = head1.next;
            head1.next = tempHead.next;
            tempHead.next = head1;
            head1 = temp;
        }
        head1 = tempHead.next;
        while (head != null && head1 != null) {
            ListNode temp = head.next;
            head.next = head1;
            head1 = head1.next;
            head.next.next = temp;
            head = temp;
        }
    }
}


