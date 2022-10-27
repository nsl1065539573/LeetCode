package medium.num133;

import datastruct.graph.Node;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Node node = new Node(1);
    Node node1 = new Node(2);
    Node node2 = new Node(3);
    Node node3 = new Node(4);
    node.neighbors.add(node1);
    node.neighbors.add(node3);
    node1.neighbors.add(node);
    node1.neighbors.add(node2);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node);
    node3.neighbors.add(node2);
    solution.cloneGraph(node);
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    List<Node> list = new LinkedList<>();
    list.add(node);
    int size = 1;
    while (!list.isEmpty()) {
      for (int i = 0; i < size; i++) {
        Node temp = list.remove(0);
        if (set.contains(temp.val)) {
          continue;
        }
        Node copier = map.containsKey(temp.val) ? map.get(temp.val) : new Node(temp.val);
        set.add(temp.val);
        map.put(temp.val, copier);
        for (Node node1 : temp.neighbors) {
          if (map.containsKey(node1.val)) {
            copier.neighbors.add(map.get(node1.val));
          } else {
            Node node2 = new Node(node1.val);
            copier.neighbors.add(node2);
            map.put(node1.val, node2);
          }
          list.add(node1);
        }
      }
    }
    return map.get(node.val);
  }
}
