package easy.offer29;

public class Solution {
  public int[] spiralOrder(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) {
      return new int[0];
    }
    int n = matrix[0].length;
    if (n == 0) {
      return new int[0];
    }
    int max = m * n;
    int index = 0;
    int[] res = new int[max];
    int top = 0;
    int left = 0;
    int right = n - 1;
    int bottom = m - 1;
    while (index < max) {
      for (int i = left; i <= right &&index<max; i++, index++) {
        res[index] = matrix[top][i];
      }
      top++;
      for (int i = top; i <= bottom && index < max; i++, index++) {
        res[index] = matrix[i][right];
      }
      right--;
      for (int i = right; i >= left &&index<max; i--, index++) {
        res[index] = matrix[bottom][i];
      }
      bottom--;
      for (int i = bottom; i>= top && index < max; i--, index++) {
        res[index] = matrix[i][left];
      }
      left++;
    }
    return res;
  }
}
