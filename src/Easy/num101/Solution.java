package Easy.num101;

public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return domain(root.left, root.right);
  }
  public boolean domain(TreeNode node1, TreeNode node2) {
    if (node1 == node2) {
      return true;
    }
    if (node1 == null || node2 == null || node2.val != node1.val) {
      return false;
    }
    return domain(node1.left, node2.right) && domain(node1.right, node2.left);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
