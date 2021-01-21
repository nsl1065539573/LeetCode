package Medium.num721;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    List<List<String>> accounts = new LinkedList<>();
    accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
    accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
    accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    accounts.add(Arrays.asList("Mary", "mary@mail.com"));
    Solution solution = new Solution();
    List res = solution.accountsMerge(accounts);
    System.out.println(res.toString());
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> res = new LinkedList<>();
    HashMap<String, Integer> mail2Index = new HashMap<>();
    int count = 0;
    for (List<String> item : accounts) {
      for (int i = 1; i < item.size(); i++) {
        mail2Index.put(item.get(i), count);
        count++;
      }
    }
    int[] fa = new int[count];
    int[] rank = new int[count];
    for (int i = 0; i < count; i++) {
      fa[i] = i;
      rank[i] = 1;
    }

    return res;
  }

  private int find(int i, int[] fa) {
    return fa[i] == i ? i : (fa[i] = find(fa[i], fa));
  }

  private void merge(int i, int j, int[] fa, int[] rank) {
    int x = find(i, fa);
    int y = find(j, fa);
    if (x == y) {
      return;
    }
    if (rank[x] <= rank[y]) {
      fa[x] = y;
    } else {
      fa[y] = x;
    }
    if (rank[x] == rank[y]) {
      rank[y]++;
    }
  }
}
