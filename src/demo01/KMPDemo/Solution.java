package demo01.KMPDemo;

public class Solution {
  public static void main(String[] args) {
      Solution solution = new Solution();
      String str1 = "南松岭南松岭南松岭";
      String str2 = "南松";
      if (!solution.isContains(str1, str2)) {
        throw new RuntimeException("应该包含");
      }
      str2 = "啊啊啊";
      if (solution.isContains(str1, str2)) {
        throw new RuntimeException("不应该包含");
      }
      str1 = "nanananana啊啊啊";
      if (!solution.isContains(str1, str2)) {
        throw new RuntimeException("应该包含");
      }
  }

  /**
   * 判断str1是否包含str2，true包含，false不包含
   * @param str1 母字符串
   * @param str2 子字符串
   * @return 是否包含
   */
  public boolean isContains(String str1, String str2) {
    if (str1 == null && str2 == null) {
      return true;
    }
    if (str1 == null) {
      return false;
    }
    if (str1.length() < str2.length()) {
      return false;
    }
    int size = str1.length();
    int len = str2.length();
    for (int i = len; i <= size; i++) {
      String temp = str1.substring(i - len, i);
      if (temp.equals(str2)) {
        return true;
      }
    }
    return false;
  }
}
