package Easy.num832;

public class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length / 2; j++) {
        int temp = A[i][j];
        A[i][j] = A[i][A[i].length - j - 1] == 1 ? 0 : 1;
        A[i][A[i].length - j - 1] = temp == 1? 0: 1;
      }
      if ((A[i].length & 1) != 0) {
        A[i][A[i].length / 2] =  A[i][A[i].length / 2] == 1? 0:1;
      }
    }
    return A;
  }
}
