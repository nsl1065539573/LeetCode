package num40;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum2(nums, target);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(res, new TreeSet<Integer>(), new LinkedList<>(), candidates, target, 0);
        return res;
    }

    /**
     * 回溯算法
     * @param res 结果集
     * @param track 记录路径
     * @param candidates 选择列表，不在路径中的就是选择列表
     * @param target 和sum组成结束条件
     * @param sum 与target组成结束条件
     */
    public void backTrack(List<List<Integer>> res, Set<Integer> visited, LinkedList<Integer> track, int[] candidates, int target, int sum) {
        // 结束条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> temp = new LinkedList<>(track);
            Collections.sort(temp);
            if (!res.contains(temp))
                res.add(temp);
        }
        for (int i = 0; i < candidates.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            track.add(candidates[i]);
            visited.add(i);
            sum += candidates[i];
            backTrack(res, visited, track, candidates, target, sum);
            track.removeLast();
            visited.remove(i);
            sum -= candidates[i];
        }
    }
}
