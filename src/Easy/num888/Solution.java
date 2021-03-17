package Easy.num888;

import java.util.HashMap;

public class Solution {
  public int[] fairCandySwap(int[] A, int[] B) {
    int[] res = new int[2];
    HashMap<Integer, Boolean> map = new HashMap<>();
    for (int i : A) {
      map.put(i, true);
    }
    int target = 0;
    int cur = 0;
    for (int i : A) {
      target += i;
    }
    for (int j : B) {
      target += j;
      cur += j;
    }
    target = target / 2;
    for (int i : B) {
      Boolean item = map.get(target - cur + i);
      if (item != null && item) {
        res[0] = target - cur + i;
        res[1] = i;
        return res;
      }
    }
    return res;
  }
}
