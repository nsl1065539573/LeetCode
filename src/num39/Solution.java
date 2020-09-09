package num39;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2,3,5};
        solution.combinationSum(test, 8);
        for (List<Integer> item:
                solution.res) {
            System.out.println(item.toString());
        }
    }

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(candidates, target, track, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, LinkedList<Integer> track, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            LinkedList<Integer> temp = new LinkedList<>(track);
            Collections.sort(temp);
            if (!res.contains(temp))
                res.add(temp);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, track, sum);
            track.removeLast();
            sum -= candidates[i];
        }
    }
}
