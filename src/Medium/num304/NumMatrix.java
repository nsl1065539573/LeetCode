package Medium.num304;

public class NumMatrix {
  private int[][] data;

  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    if (m > 0) {
      int n = matrix[0].length;
      this.data = new int[m + 1][n + 1];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          data[i+1][j+1] = data[i][j+1] + data[i+1][j] - data[i][j] + matrix[i][j];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return data[row1+1][col1+1] - data[row1][col2+1] - data[row2+1][col1] + data[row1][col1];
  }
}
