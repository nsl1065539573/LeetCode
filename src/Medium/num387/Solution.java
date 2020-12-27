package Medium.num387;

import java.util.HashMap;

public class Solution {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.merge(s.charAt(i), 1, Integer::sum);
    }
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return  -1;
  }
}
