package Easy.num867;

public class Solution {
  public int[][] transpose(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return matrix;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] res = new int[n][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res[j][i] = matrix[i][j];
      }
    }
    return res;
  }
}
