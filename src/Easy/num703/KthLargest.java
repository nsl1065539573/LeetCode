package Easy.num703;

public class KthLargest {
  private final int k;
  private final Node dummy;
  private Node topK;

  public static void main(String[] args) {
    int[] arr = {0};
    KthLargest kthLargest = new KthLargest(2, arr);
    System.out.println(kthLargest.add(-1));
    System.out.println(kthLargest.add(1));
    System.out.println(kthLargest.add(-2));
    System.out.println(kthLargest.add(-4));
    System.out.println(kthLargest.add(3));
  }

  public KthLargest(int k, int[] nums) {
    this.dummy = new Node(Integer.MIN_VALUE);
    this.k = k;
    for (int i: nums) {
      Node node = new Node(i);
      add(node);
    }
  }

  public int add(int val) {
    Node addition = new Node(val);
    add(addition);
    Node temp = dummy;
    int index = 0;
    while (index < k) {
      temp = temp.next;
      index ++;
    }
    return temp.val;
  }

  class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private void add(Node node) {
    Node temp = dummy;
    if (dummy.next == null) {
      dummy.next = node;
    } else {
      while (true) {
        if (node.val > temp.next.val) {
          Node next = temp.next;
          temp.next = node;
          node.next = next;
          return;
        } else {
          temp = temp.next;
        }
        if (temp.next == null) {
          temp.next = node;
          return;
        }
      }
    }

  }
}
