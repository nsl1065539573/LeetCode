package Easy.num205;

import java.util.HashMap;

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> s2t = new HashMap<>();
    HashMap<Character, Character> t2s = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char a = s.charAt(i);
      char b = t.charAt(i);
      if ((s2t.containsKey(b) && a != s2t.get(b)) || (t2s.containsKey(a) && b != t2s.get(a))) {
        return false;
      }
      s2t.put(b, a);
      t2s.put(a, b);
    }
    return true;
  }
}
