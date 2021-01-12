package nowCode.Medium.NC15;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
  public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
    // write code here
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    LinkedList<TreeNode> list = new LinkedList<>();
    LinkedList<Integer> level = new LinkedList<>();
    list.add(root);
    int cur = 1;
    while (list.size() > 0) {
      TreeNode node = list.removeFirst();
      level.add(node.val);
      if (node.left != null) {
        list.add(node.left);
      }
      if (node.right != null) {
        list.add(node.right);
      }
      cur--;
      if (cur == 0) {
        cur = list.size();
        res.add(new ArrayList<>(level));
        level.clear();
      }
    }
    return res;
  }
}

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
}