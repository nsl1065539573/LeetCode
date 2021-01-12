package demo01.linkedListDemo;

public class Main {
  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
//    reverse(node1);
//    list(node5);
    Main main = new Main();
    ListNode node = main.reverseN(node1, 3);
    list(node);
  }

  public static ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode last = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

  private ListNode next = null;

  public  ListNode reverseN(ListNode head, int n) {
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
  ListNode(int x) { val = x; }
}
