package Easy.num257;

import Easy.dataStruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode node = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(5);
    node.left = node1;
    node.right = node2;
    node1.right = node3;
    List<String> res = solution.binaryTreePaths(node);
    System.out.println(res);
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    List<Integer> track = new LinkedList<>();
    dfs(track, root, res);
    return res;
  }

  public void dfs(List<Integer> track, TreeNode root, List<String> res) {
    if (root.left == null && root.right == null) {
      StringBuilder sb = new StringBuilder();
      for (Integer integer : track) {
        sb.append(integer);
        sb.append("->");
      }
      sb.append(root.val);
      res.add(sb.toString());
      return;
    }
    track.add(root.val);
    if (root.left != null) {
      dfs(track, root.left, res);
    }
    if (root.right != null) {
      dfs(track, root.right, res);
    }
    track.remove(track.size() - 1);
  }
}
