package Easy.dataStruct;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        '}';
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
