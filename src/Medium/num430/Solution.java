package Medium.num430;

public class Solution {
    public Node flatten(Node head) {
        return new Node();
    }

    public static void domain(Node temp, Node head) {
        if (head.next == null) {
            temp.next = head;
            temp = temp.next;
            return;
        }

        if (head.child != null) {
            Solution.domain(temp, head.child);
        }
        if (head.next != null) {
            Solution.domain(temp, head.next);
        }
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}