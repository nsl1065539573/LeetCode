package num216;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 *     所有数字都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum3(3, 9);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(k, n, new TreeSet<>(), 0, 1, res);
        return res;
    }

    /**
     * 回溯函数主体
     * @param k 数字个数
     * @param n 和为n 即结束条件需要包含 n==sum
     * @param track 已经走过的路径
     * @param sum 目前路径内的数字和
     * @param times 之前走过的次数
     */
    public void backTrack(int k, int n, TreeSet<Integer> track, int sum, int times, List<List<Integer>> res) {
        if (k < track.size()) {
            return;
        }
        if (k == track.size()) {
            if (sum == n) {
                LinkedList<Integer> temp = new LinkedList<>(track);
                if (!res.contains(temp))
                    res.add(temp);
                return;
            }else {
                return;
            }
        }
        for (int i = times; i < 10; i ++) {
            if (track.contains(i)) {
                continue;
            }
            track.add(i);
            sum += i;
            backTrack(k, n, track, sum, times + 1, res);
            sum -= i;
            track.remove(i);
        }
    }
}
