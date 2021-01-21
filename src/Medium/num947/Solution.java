package Medium.num947;

public class Solution {
  public int removeStones(int[][] stones) {
    int[] fa = new int[20001];
    int[] next = new int[20001];
    // init
    for (int i = 0; i < 20001; i++) {
      fa[i] = -1;
      next[i] = 1;
    }
    for (int[] item: stones) {
      merge(item[0] + 10000, item[1], fa, next);
    }
    return stones.length - count(fa);
  }

  private int find(int i, int[] fa) {
    if (fa[i] < 0) {
      fa[i] = i;
      return i;
    }
    return fa[i] == i ? i : (fa[i] = find(fa[i], fa));
  }

  private void merge(int i, int j, int[] fa, int[] rank) {
    int x = find(i, fa);
    int y = find(j, fa);
    if (x == y) {
      return;
    }
    if (rank[x] <= rank[y]) {
      fa[x] = fa[y];
    } else {
      fa[y] = fa[x];
    }
    if (rank[x] == rank[y]) {
      rank[y] ++;
    }
  }

  private int count(int[] fa) {
    int res = 0;
    for (int i = 0; i < 20000; i++) {
      if (fa[i] == i) {
        res++;
      }
    }
    return res;
  }

}
