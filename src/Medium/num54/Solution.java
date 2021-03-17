package Medium.num54;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    Solution solution = new Solution();
    System.out.println(solution.spiralOrder(matrix).toString());
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new LinkedList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }
    int left = 0;
    int right = matrix[0].length - 1;
    int top = 0;
    int bottom = matrix.length - 1;
    int index = matrix.length * matrix[0].length;
    while (index > 0) {
      // 从左到右，然后行要加一
      for (int i = left; i <= right; i++) {
        if (index > 0) {
          res.add(matrix[top][i]);
          index--;
        }
      }
      top++;
      // 从上到下
      for (int i = top; i <= bottom; i++) {
        if (index > 0) {
          res.add(matrix[i][right]);
          index--;
        }
      }
      right--;
      // 从右到左
      for (int i = right; i >= left; i--) {
        if (index > 0) {
          res.add(matrix[bottom][i]);
          index--;
        }
      }
      bottom--;
      // 从下到上
      for (int i = bottom; i >= top; i--) {
         if (index > 0) {
           res.add(matrix[i][left]);
           index--;
         }
      }
      left++;
    }
    return res;
  }
}
