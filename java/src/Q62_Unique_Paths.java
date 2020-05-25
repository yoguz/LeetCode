public class Q62_Unique_Paths {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; ++i) {
            grid[i][0] = 1;
        }

        for (int i = 0; i < n; ++i) {
            grid[0][i] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        Q62_Unique_Paths obj = new Q62_Unique_Paths();
        System.out.println(obj.uniquePaths(3,8));
        System.out.println(obj.uniquePaths(5,10));
        System.out.println(obj.uniquePaths(50,100));
    }
}
