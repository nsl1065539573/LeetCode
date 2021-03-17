package Easy.num700;

import Easy.dataStruct.TreeNode;

public class Solution {
  public static void main(String[] args) {
    TreeNode node = new TreeNode(4);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(7);
    TreeNode node3 = new TreeNode(1);
    TreeNode node4 = new TreeNode(3);
    node.left = node1;
    node.right = node2;
    node1.left = node3;
    node1.right = node4;
    Solution solution = new Solution();
    System.out.println(solution.searchBST(node, 2));
  }

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    if (root.val > val) {
      return searchBST(root.left, val);
    }
    return searchBST(root.right, val);
  }
}
