package easy.num929;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: nansongling
 * @Date: 2022/10/13 10:04 AM
 **/
public class Solution {
  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (String email: emails) {
      String actual = getActualEmail(email);
      set.add(actual);
    }
    return set.size();
  }

  private String getActualEmail(String origin) {
    String[] strings = origin.split("@");
    String[] strings1 = strings[0].split("\\+");
    String[] strings2 = strings1[0].split("\\.");
    StringBuilder stringBuilder = new StringBuilder();
    for (String s : strings2) {
      stringBuilder.append(s);
    }
    stringBuilder.append("@");
    stringBuilder.append(strings[1]);
    return stringBuilder.toString();
  }
}
