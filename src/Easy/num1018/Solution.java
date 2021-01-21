package Easy.num1018;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Boolean> prefixesDivBy5(int[] A) {
    int n = A.length;
    List<Boolean> res = new ArrayList<>(n);
    int num = 0;
    for (int j : A) {
      num = 2 * num + j;
      if (num % 5 == 0) {
        res.add(true);
      } else {
        res.add(false);
      }
    }
    return res;
  }
}
