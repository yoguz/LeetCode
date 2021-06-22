public class Q200_Number_of_Islands {

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] != '1')
            return;

        grid[i][j] = '-';
        bfs(grid, i, j+1, n, m);
        bfs(grid, i, j-1, n, m);
        bfs(grid, i-1, j, n, m);
        bfs(grid, i+1, j, n, m);
    }

    public static void main(String[] args) {
        Q200_Number_of_Islands obj = new Q200_Number_of_Islands();
        char [][]grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(obj.numIslands(grid));
    }
}
