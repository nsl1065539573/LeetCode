package medium.num785;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] graph = new int[][]{{3}, {2, 4}, {1}, {0, 4}, {1, 3}};
    System.out.println(solution.isBipartite(graph));
  }

  public boolean isBipartite(int[][] graph) {
    // 广度优先
    int[] window = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (window[i] != 0) {
        continue;
      }
      LinkedList<Integer> queue = new LinkedList<>();
      queue.addLast(i);
      window[i] = 1;
      while (!queue.isEmpty()) {
        int temp = queue.removeFirst();
        for (int j = 0; j < graph[temp].length; j++) {
          if (window[graph[temp][j]] != 0) {
            if (window[graph[temp][j]] == window[temp]) {
              return false;
            }
          } else {
            window[graph[temp][j]] = window[temp] == 1 ? 2 : 1;
            queue.addLast(graph[temp][j]);
          }
        }
      }
    }
    return true;
  }
}
