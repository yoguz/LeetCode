public class Q63_Unique_Paths_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        boolean obs = false;
        for (int i = 1; i < obstacleGrid.length; ++i) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = -1;
                obs = true;
            } else if (!obs) {
                obstacleGrid[i][0] = 1;
            }
        }

        obs = false;
        for (int i = 1; i < obstacleGrid[0].length; ++i) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = -1;
                obs = true;
            } else if (!obs) {
                obstacleGrid[0][i] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; ++i) {
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                } else {
                    obstacleGrid[i][j] += obstacleGrid[i-1][j] != -1 ? obstacleGrid[i-1][j] : 0;
                    obstacleGrid[i][j] += obstacleGrid[i][j-1] != -1 ? obstacleGrid[i][j-1] : 0;

                }
            }
        }

        return Math.max(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1], 0);
    }

    public static void main(String[] args) {
        Q63_Unique_Paths_II obj = new Q63_Unique_Paths_II();
        int[][] grid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(obj.uniquePathsWithObstacles(grid));
        grid = new int[][]{
                {0}
        };
        System.out.println(obj.uniquePathsWithObstacles(grid));
        grid = new int[][]{
                {0,1}
        };
        System.out.println(obj.uniquePathsWithObstacles(grid));
    }
}
