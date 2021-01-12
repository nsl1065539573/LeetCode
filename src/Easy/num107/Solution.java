package Easy.num107;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    LinkedList<TreeNode> list = new LinkedList<>();

    int cur = 1;
    list.add(root);
    while (list.size() > 0) {
      LinkedList<Integer> list1 = new LinkedList<>();
      TreeNode node = list.removeFirst();
      cur --;
      list1.add(node.val);
      if (node.left != null) {
        list.add(node.left);
      }
      if (node.right != null) {
        list.add(node.right);
      }
      if (cur == 0) {
        cur = list.size();
        res.add(0, new ArrayList<>(list1));
        list1.clear();
      }
    }
    return res;
  }

  public List<List<Integer>> other(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    while (list.size() > 0) {
      LinkedList<Integer> list1 = new LinkedList<>();
      for (int i = 0; i < list.size(); i++) {
        TreeNode node = list.removeFirst();
        list1.add(node.val);
        if (node.left != null) {
          list.add(node.left);
        }
        if (node.right != null) {
          list.add(node.right);
        }
      }
      res.add(0, new ArrayList<>(list1));
    }
    return res;
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