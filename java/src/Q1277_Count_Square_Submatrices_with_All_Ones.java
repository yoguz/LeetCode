public class Q1277_Count_Square_Submatrices_with_All_Ones {

    public int countSquares(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q1277_Count_Square_Submatrices_with_All_Ones obj = new Q1277_Count_Square_Submatrices_with_All_Ones();
        int[][] A = new int[][]{
                {1,0,1,1,1},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,1,0,0,1},
                {0,1,0,1,0}
        };
        System.out.println(obj.countSquares(A));
    }

}
