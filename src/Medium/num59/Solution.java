package Medium.num59;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.generateMatrix(3);
  }

  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int index = 1;
    int top = 0;
    int right = n - 1;
    int bottom = n - 1;
    int left = 0;
    int size = n * n;
    while (index <= size) {
      // 从左到右
      for (int i = left; i <= right; i++) {
        if (index <= size) {
          res[top][i] = index;
          index++;
        }
      }
      top++;
      // 从上到下
      for (int i = top; i <= bottom; i++) {
        if (index <= size) {
          res[i][right] = index;
          index++;
        }
      }
      right--;
      // 从右往左
      for (int i = right; i >= left; i--) {
        if (index <= size) {
          res[bottom][i] = index;
          index++;
        }
      }
      bottom--;
      // 从下往上
      for (int i = bottom; i >= top; i--) {
        if (index <= size) {
          res[i][left] = index;
          index++;
        }
      }
      left++;
    }
    return res;
  }
}
