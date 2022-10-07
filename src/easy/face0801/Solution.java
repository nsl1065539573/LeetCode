package easy.face0801;

public class Solution {
  public int waysToStep(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 4;
    }
    long temp1 = 1;
    long temp2 = 2;
    long temp3 = 4;
    long temp4 = 0;
    for (int i = 4; i <= n; i++) {
      temp4 = (temp1 + temp2 + temp3) % 1000000007L;
      temp1 = temp2;
      temp2 = temp3;
      temp3 = temp4;
    }
    return (int) temp4;
  }
}
