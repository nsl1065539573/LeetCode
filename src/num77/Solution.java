package num77;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List res = solution.combine(4, 2);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(res, track, n, k, 1);
        return res;
    }

    public void backTrack(List<List<Integer>> res, LinkedList<Integer> track, int n, int k, int begin) {
        if (track.size() == k) {
            LinkedList temp = new LinkedList<>(track);
            res.add(temp);
            return;
        }
        for (int i = begin; i <= n; i++) {
            track.addLast(i);
            backTrack(res, track, n, k, i + 1);
            track.removeLast();
        }
    }
}
