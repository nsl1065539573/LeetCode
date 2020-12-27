package Medium.num103;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20);
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    node1.left = node2;
    node1.right = node3;
    node3.left = node4;
    node3.right = node5;
    Solution solution = new Solution();
    solution.zigzagLevelOrder(node1);
  }
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<TreeNode> list = new LinkedList<>();
    list.addLast(root);
    int cur = 1;
    int level = 0;
    while (list.size() > 0) {
      List<Integer> temp = new LinkedList<>();
      if (level%2 == 0) {
        for (int i = 0; i < cur; i++) {
          temp.add(list.get(i).val);
        }
      } else {
        for (int i = cur - 1; i >= 0; i--) {
          temp.add(list.get(i).val);
        }
      }
      for (int i = 0; i < cur; i++) {
        root = list.removeFirst();
        if (root.left != null) {
          list.add(root.left);
        }
        if (root.right != null) {
          list.add(root.right);
        }
      }
      res.add(temp);
      cur = list.size();
      level ++;
    }
    return res;
  }
}
