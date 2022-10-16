package medium.num93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.restoreIpAddresses("101023"));
  }

  // 回溯算法
  public List<String> restoreIpAddresses(String s) {
    List<String> res=  new LinkedList<>();
    backup(res, new StringBuilder(), 0, s, 4);
    return res;
  }

  public void backup(List<String> res, StringBuilder trace, int begin, String s, int remainBit) {
    int len = s.length();
    if (begin == len && remainBit == 0) {
      res.add(trace.toString());
      return;
    }
    if (remainBit == 0) {
      return;
    }
    // 只能是0-255
    for (int i = 0; i < 3 && i + begin + 1 <= len; i++) {
      // 位数不能以0开头，但可以是0
      if (i > 0 && s.charAt(begin) == '0') {
        return;
      }
      // 剩余位数乘以三是最大可以接受的剩余的长度，最小需要和剩余长度相等
      int remain = s.length() - begin - i + 1;
      if (remain > remainBit * 3 || remain < remainBit) {
        continue;
      }
      String temp = s.substring(begin, begin +i +1);
      int tempInt = Integer.parseInt(temp);
      if (tempInt > 255) {
        return;
      }
      trace.append(temp);
      if (remainBit > 1) {
        trace.append('.');
      }
      backup(res, trace, begin + i +1, s, remainBit - 1);
      if (remainBit > 1) {
        trace.deleteCharAt(trace.length() - 1);
      }
      trace.delete(trace.length() - i - 1, trace.length());
    }
  }
}
