package Easy.num112;

import Easy.dataStruct.TreeNode;

public class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null && targetSum != 0) {
      return false;
    }
    if (root == null) {
      return true;
    }
    return dfs(root, targetSum, 0);
  }

  private boolean dfs(TreeNode root, int targetSum, int curSum) {
    if (root == null) {
      return false;
    }
    curSum += root.val;
    if (curSum == targetSum && root.left == null && root.right == null) {
      return true;
    }
    boolean leftTrue = dfs(root.left, targetSum, curSum);
    boolean rightTrue = dfs(root.right, targetSum, curSum);
    return leftTrue || rightTrue;
  }
}
