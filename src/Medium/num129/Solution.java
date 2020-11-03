package Medium.num129;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> list = new LinkedList<>();
        Solution.dfs(root, new StringBuffer(), list);
        int res = 0;
        for (String s:
             list) {
            res += Integer.parseInt(s);
        }
        return res;
    }

    public static void dfs(TreeNode root, StringBuffer track, List<String> res) {
        if (root.left == null && root.right == null) {
            track.append(root.val);
            res.add(track.toString());
            System.out.println(res);
            return;
        }
        track.append(root.val);
        if (root.left != null) {
            dfs(root.left, track, res);
            track.deleteCharAt(track.length() - 1);
        }
        if (root.right != null) {
            dfs(root.right, track, res);
            track.deleteCharAt(track.length() - 1);
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}