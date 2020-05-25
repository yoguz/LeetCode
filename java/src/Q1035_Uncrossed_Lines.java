public class Q1035_Uncrossed_Lines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] memo = new int[A.length][B.length];

        int point;
        for (int i = A.length-1; i >= 0; --i) {
            for (int j = B.length-1; j >= 0; --j) {
                point = A[i] == B[j] ? 1 : 0;
                memo[i][j] = Math.max(point+get(memo,i+1,j+1), Math.max(get(memo,i+1,j), get(memo,i,j+1)));
            }
        }
        return memo[0][0];
    }

    private int get(int[][] memo, int i, int j) {
        if (i >= memo.length || j >= memo[0].length)
            return 0;
        return memo[i][j];
    }

    public static void main(String[] args) {
        Q1035_Uncrossed_Lines obj = new Q1035_Uncrossed_Lines();
        System.out.println(obj.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(obj.maxUncrossedLines(new int[]{0}, new int[]{0}));
        System.out.println(obj.maxUncrossedLines(new int[]{0}, new int[]{1}));
        System.out.println(obj.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(obj.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}
