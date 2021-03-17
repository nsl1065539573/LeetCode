package Medium.num1208;

public class Solution {
  // todo：包左且包右
  public static void main(String[] args) {
    String s = "abcd";
    String t = "bcde";
    Solution solution = new Solution();
    System.out.println(solution.equalSubstring(s, t, 3));
  }

  public int equalSubstring(String s, String t, int maxCost) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    char[] chars = s.toCharArray();
    char[] chars1 = t.toCharArray();
    int[] diff = new int[chars.length];
    for (int i = 0; i < diff.length; i++) {
      diff[i] = Math.abs(chars[i] - chars1[i]);
    }
    int left = 0;
    int right = 0;
    int res = 0;
    int sumCost = 0;
    while (right < s.length()) {
      sumCost += diff[right];
      right++;
      while (sumCost > maxCost) {
        sumCost -= diff[left];
        left++;
      }
      int curLen = right - left;
      if (curLen > res) {
        res = curLen;
      }
    }
    return res;
  }
}
