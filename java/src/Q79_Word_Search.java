import java.util.HashSet;
import java.util.Set;

public class Q79_Word_Search {
/* ORIGINAL IDEA
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (helper(board, word, 0, i, j, new HashSet<>()))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int wordIndex, int i, int j, Set<String> set) {
        if (wordIndex == word.length())
            return true;

        if (i == board.length || i < 0
                || j == board[0].length || j < 0
                || set.contains(i + "-" + j)
                || word.charAt(wordIndex) != board[i][j])
            return false;

        set.add(i + "-" + j);

        return helper(board, word, wordIndex+1, i-1, j, new HashSet<>(set))
                || helper(board, word, wordIndex+1, i+1, j, new HashSet<>(set))
                || helper(board, word, wordIndex+1, i, j-1, new HashSet<>(set))
                || helper(board, word, wordIndex+1, i, j+1, new HashSet<>(set));

    }
*/

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (helper(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int wordIndex, int i, int j) {
        if (wordIndex == word.length())
            return true;

        if (i == board.length || i < 0
                || j == board[0].length || j < 0
                || board[i][j] == ' '
                || word.charAt(wordIndex) != board[i][j])
            return false;

        board[i][j] = ' ';

        boolean res =  helper(board, word, wordIndex+1, i-1, j)
                || helper(board, word, wordIndex+1, i+1, j)
                || helper(board, word, wordIndex+1, i, j-1)
                || helper(board, word, wordIndex+1, i, j+1);

        board[i][j] = word.charAt(wordIndex);
        return res;
    }

    public static void main(String[] args) {
        Q79_Word_Search obj = new Q79_Word_Search();
        char[][] grid = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(obj.exist(grid, "ABCCED"));

        grid = new char[][] {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        System.out.println(obj.exist(grid, "AAB"));
    }
}
