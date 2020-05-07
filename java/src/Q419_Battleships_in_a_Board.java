public class Q419_Battleships_in_a_Board {

    public int countBattleships(char[][] board) {
        int rows = board.length;
        if (rows == 0)
            return 0;

        int cols = board[0].length;
        if (cols == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (i == 0 && j == 0 && board[i][j] == 'X') {
                    count++;
                } else if (i == 0) {
                    if (board[i][j] == 'X' && board[i][j-1] != 'X')
                        count++;
                } else if (j == 0) {
                    if (board[i][j] == 'X' && board[i-1][j] != 'X')
                        count++;
                } else if (board[i][j] == 'X' && board[i-1][j] != 'X' && board[i][j-1] != 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
        };
        Q419_Battleships_in_a_Board obj = new Q419_Battleships_in_a_Board();
        System.out.println(obj.countBattleships(board));
    }
}
