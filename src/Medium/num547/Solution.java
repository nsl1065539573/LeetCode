package Medium.num547;

public class Solution {
  public static void main(String[] args) {
    int[][] isConnected =
        {{1,1,0},{1,1,0},{0,0,1}};
    Solution solution = new Solution();
    solution.findCircleNum(isConnected);
  }

  public int findCircleNum(int[][] isConnected) {
    int length = isConnected.length;
    int res = 0;
    boolean[] isVisited = new boolean[length];
    for (int i = 0; i < length; i++) {
      if (!isVisited[i]) {
        dfs(i, isVisited, isConnected);
        res++;
      }
    }
    return res;
  }
  public void dfs(int i, boolean[] isVisited, int[][] isConnected) {
    for (int j = 0; j < isConnected.length; j++) {
      if (!isVisited[j] && isConnected[i][j] == 1) {
        isVisited[j] = true;
        dfs(j, isVisited, isConnected);
      }
    }
  }
}
