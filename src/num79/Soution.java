package num79;

class Solution {

    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
        char[][] board = {{'a', 'a'}};
        Solution solution = new Solution();
        System.out.println(solution.exist(board, "aa"));
    }

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, 0, word, i, j, visited, board[0].length)) {
                    return true;
                }
            }
        }
        return  false;
    }

    public boolean dfs(char[][] board, int index, String word, int x, int y, int[][] visited, int aa) {
        char c = word.charAt(index);
        // 结束条件
        if (c != board[x][y]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 选择列表
        // 做选择
        visited[x][y] = 1;
        if ( x + 1 < board.length && visited[x + 1][y] != 1) {
            if (dfs(board, index + 1, word, x, y + 1, visited, aa)) {
                return true;
            }
            visited[x][y] = 0;
        }
        if (y + 1 < aa  && visited[x][y + 1] != 1) {
            if (dfs(board, index + 1, word, x + 1, y, visited, aa)) {
                return true;
            }
            visited[x][y] = 0;
        }
        if (y - 1 >= 0 && visited[x][y - 1] != 1) {
            if (dfs(board, index + 1, word, x - 1, y, visited, aa)) {
                return true;
            }
            visited[x][y] = 0;
        }
        if ( x - 1 >= 0 && visited[x - 1][y] != 1) {
            if (dfs(board, index + 1, word, x, y - 1, visited, aa)) {
                return true;
            }
            visited[x][y] = 0;
        }

        return false;
    }
}
