public class Q130_Surrounded_Regions {

    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2)
            return;

        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; ++i) {
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }

        for (int j = 1; j < m-1; ++j) {
            dfs(board, 0, j);
            dfs(board, n-1, j);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '-')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X')
            return;

        board[i][j] = '-';
        if (i > 0 && board[i-1][j] == 'O')
            dfs(board, i-1, j);
        if (j > 0 && board[i][j-1] == 'O')
            dfs(board, i, j-1);
        if (i < board.length-1 && board[i+1][j] == 'O')
            dfs(board, i+1, j);
        if (j < board[0].length-1 && board[i][j+1] == 'O')
            dfs(board, i, j+1);
    }

    public static void main(String[] args) {
        Q130_Surrounded_Regions obj = new Q130_Surrounded_Regions();
        char[][] board = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        obj.solve(board);
        for (char[] row: board) {
            for (char c: row)
                System.out.print("\"" + c + "\", ");
            System.out.println();
        }
    }
}
