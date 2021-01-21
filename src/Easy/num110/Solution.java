package Easy.num110;

import javax.xml.soap.Node;

public class Solution {
  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(4);
    node.left = node1;
    node.right = node2;
    node1.left = node3;
    node1.right = node4;
    node3.left = node5;
    node3.right = node6;
    Solution solution = new Solution();
    solution.isBalanced(node);
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    System.out.println(height(root.left));
    System.out.println(height(root.right));
    return Math.abs(height(root.left) - height(root.right)) > 1;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return (Math.max(height(root.left), height(root.right))) + 1;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}