public class Q72_Edit_Distance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m == 0) return n;
        else if (n == 0) return m;

        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i <= m; ++i)
            memo[i][0] = i;

        for (int i = 0; i <= n; ++i)
            memo[0][i] = i;

        int insert, delete, replace;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1];
                else {
                    insert = memo[i][j-1];
                    delete = memo[i-1][j];
                    replace = memo[i-1][j-1];
                    memo[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }

        return memo[m][n];
    }

    public static void main(String[] args) {
        Q72_Edit_Distance obj = new Q72_Edit_Distance();
        System.out.println(obj.minDistance("horse", "ros"));
        System.out.println(obj.minDistance("intention", "execution"));
    }
}
