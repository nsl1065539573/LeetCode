package Medium.num684;

public class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    int[] fa = new int[n + 1];
    int[] ranks = new int[n + 1];
    // init
    for (int i = 1; i < n + 1; i++) {
      fa[i] = i;
      ranks[i] = 1;
    }
    for (int[] item:
         edges) {
      int x = item[0];
      int y = item[1];
      if (find(x, fa) == find(y, fa)) {
        return item;
      } else {
        merge(x, y, fa, ranks);
      }
    }
    return new int[0];
  }
  public int find(int i, int[] fa) {
    return fa[i] == i ? i : (fa[i] = find(fa[i], fa));
  }

  public void merge(int i, int j, int[] fa, int[] rank) {
    int x = find(i, fa);
    int y = find(j, fa);
    if (rank[x] <= rank[y]) {
      fa[x] = y;
    } else {
      fa[y] = x;
    }
    if (rank[x] == rank[y] && x != y) {
      rank[y]++;
    }
  }
}
