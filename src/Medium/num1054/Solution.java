package Medium.num1054;

public class Solution {
  public static void main(String[] args) {
    int[] customers = new int[]{2,6,6,9};
    int[] grumpy = new int[]{0,0,1,1};
    int X = 1;
    Solution solution = new Solution();
    System.out.println(solution.maxSatisfied(customers, grumpy, X));
  }

  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int max = 0;
    int cur = 0;
    int targetLeft = 0;
    int targetRight = 0;
    for (int i = 0; i < X; i++) {
      if (grumpy[i] == 1) {
        cur += customers[i];
      }
      max = cur;
      targetLeft = 0;
      targetRight = X - 1;
    }
    for (int i = X; i < customers.length; i++) {
      cur = cur - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
      if (cur > max) {
        max = cur;
        targetLeft = i - X + 1;
        targetRight = i;
      }
    }
    int res = 0;
    for (int i = 0; i < customers.length; i++) {
      if (i < targetLeft || i > targetRight) {
        if (grumpy[i] == 0) {
          res += customers[i];
        }
      } else {
        res += customers[i];
      }
    }
    return res;
  }
}
