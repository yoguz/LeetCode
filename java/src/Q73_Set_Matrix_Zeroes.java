public class Q73_Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row = false, col = false;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                    if (i == 0)
                        row = true;
                    if (j == 0)
                        col = true;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 1; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (col) {
            for (int i = 1; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Q73_Set_Matrix_Zeroes obj = new Q73_Set_Matrix_Zeroes();
        int[][] mat = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        obj.setZeroes(mat);
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; ++j) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
