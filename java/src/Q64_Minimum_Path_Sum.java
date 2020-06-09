public class Q64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int row = grid.length, col = grid[0].length;
        for (int i = 1; i < row; ++i) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < col; ++i) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[row-1][col-1];
    }

    public static void main(String[] args) {
        Q64_Minimum_Path_Sum obj = new Q64_Minimum_Path_Sum();
        System.out.println(obj.minPathSum(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
