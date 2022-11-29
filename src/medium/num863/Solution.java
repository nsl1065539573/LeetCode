package medium.num863;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    assignFather(root, map);
    List<Integer> res = new LinkedList<>();
    countDistanceK(target, res, target, 0, map, k);
    return res;
  }

  private void countDistanceK(TreeNode begin, List<Integer> res, TreeNode from, int distance, Map<TreeNode, TreeNode> map, int k) {
    if (distance == k) {
      res.add(begin.val);
      return;
    }
    if (begin.left != null && begin.left != from) {
      countDistanceK(begin.left, res, begin, distance + 1, map, k);
    }
    if (begin.right != null && begin.right  != from) {
      countDistanceK(begin.right, res, begin, distance + 1, map, k);
    }
    if (map.get(begin) != null && map.get(begin) != from) {
      countDistanceK(map.get(begin), res, begin, distance + 1, map, k);
    }
  }

  private void assignFather(TreeNode root, Map<TreeNode, TreeNode> map) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      map.put(root.left, root);
    }
    if (root.right != null) {
      map.put(root.right, root);
    }
    assignFather(root.left, map);
    assignFather(root.right, map);
  }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}