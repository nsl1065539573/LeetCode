package Medium.num338;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.countBits(5)));
  }

  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      if ((i&1) == 0) {
        res[i] = res[i - 1];
      } else {
        res[i] = res[i - 1] + 1;
      }
    }
    return res;
  }
}
