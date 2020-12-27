package demo01.cups;

import java.util.HashMap;

public class Cups {
  public static void main(String[] args) {
    HashMap <Integer, Integer> res = new HashMap<Integer, Integer>();
    pour(4, 10, 8, 4, 0, res);
    for (Integer name: res.keySet()){
      String key = name.toString();
      String value = res.get(name).toString();
      System.out.println(key + " " + value);
    }
  }

  private static boolean pour(int cup1, int cup2, int g, int x1, int x2, HashMap<Integer, Integer> res) {
    if (cup1 == cup2 || cup1 + cup2 < g) {
      return false;
    }
    if (x1 == g || x2 == g || (x1 + x2) == g) {
      res.put(x1, x2);
      return true;
    }
    if (cup2 - x2 > x1) {
      return pour(cup1, cup2, g, cup1, x1 + x2, res);
    } else if (cup2 - x2 == x1) {
      return pour(cup1, cup2, g, cup1, 0, res);
    } else {
      return pour(cup1, cup2, g, x1 + x2 - cup2, 0, res);
    }
  }
}
