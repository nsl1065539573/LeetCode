package medium.num200;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
    System.out.println(solution.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          res++;
        }
      }
    }
    return res;
  }

  private void dfs(char[][] grid, int x, int y) {
    grid[x][y] = '2';
    // 上 下 左 右
    if (x - 1 >= 0 && grid[x - 1][y] == '1') {
      dfs(grid, x - 1, y);
    }
    if (x + 1 < grid.length && grid[x+1][y] == '1') {
      dfs(grid, x + 1, y);
    }
    if (y - 1 >= 0 && grid[x][y - 1] == '1') {
      dfs(grid, x, y -1);
    }
    if (y + 1<grid[0].length && grid[x][y+1] == '1') {
      dfs(grid, x, y+1);
    }
  }
}
