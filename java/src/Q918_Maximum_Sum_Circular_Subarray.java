public class Q918_Maximum_Sum_Circular_Subarray {

    public int maxSubarraySumCircularNSquaredTime1Space(int[] A) {
        if (A.length == 1)
            return A[0];
        else if (A.length == 2)
            return Math.max(A[0], Math.max(A[1], A[0] + A[1]));

        int max = A[0], cur;
        int len = A.length;

        for (int i = 0; i < len; ++i) {
            if (A[i] > max)
                max = A[i];
        }

        for (int i = 0; i < len-1; ++i) {
            cur = A[i];
            for (int j = i+1; j < len; ++j) {
                cur = cur + A[j];
                if (cur > max)
                    max = cur;
            }
        }

        cur = A[0] + A[len-1];
        if (cur > max)
            max = cur;

        for (int j = 1; j < len-1; ++j) {
            cur = cur + A[j];
            if (cur > max)
                max = cur;
        }

        int prev = A[0] + A[len-1] + A[len-2];

        for (int i = len-2; i > 0; --i) {
            cur = prev;
            if (prev > max)
                max = prev;
            for (int j = 1; j < i; ++j) {
                cur = cur + A[j];
                if (cur > max)
                    max = cur;
            }
            prev = prev + A[i-1];
        }

        return max;
    }

    public int maxSubarraySumCircularNSquaredSpaceAndTime(int[] A) {
        if (A.length == 1)
            return A[0];

        int[][] matrix;
        int len = A.length, max = A[0];
        matrix = new int[len][len];

        for (int i = 0; i < len; ++i) {
            matrix[i][i] = A[i];
            if (matrix[i][i] > max)
                max = matrix[i][i];
        }

        for (int i = 0; i < len; ++i) {
            for (int j = i+1; j < len; ++j) {
                matrix[i][j] = matrix[i][j-1] + matrix[j][j];
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }
        }

        matrix[len-1][0] = matrix[0][0] + matrix[len-1][len-1];
        if (matrix[len-1][0] > max)
            max = matrix[len-1][0];

        for (int i = len-2; i > 0; --i) {
            matrix[i][0] = matrix[i+1][0] + matrix[i][i];
            if (matrix[i][0] > max)
                max = matrix[i][0];
        }

        for (int j = 1; j < len-1; ++j) {
            for (int i = len-1; i>j; --i) {
                matrix[i][j] = matrix[i][j-1] + matrix[j][j];
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }
        }

        return max;
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 1)
            return A[0];
        else if (A.length == 2)
            return Math.max(A[0], Math.max(A[1], A[0] + A[1]));

        int S = 0;  // S = sum(A)
        for (int x: A)
            S += x;

        int ans1 = kadane(A, 0, A.length-1, 1);
        int ans2 = S + kadane(A, 1, A.length-1, -1);
        int ans3 = S + kadane(A, 0, A.length-2, -1);
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public int kadane(int[] A, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            cur = sign * A[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q918_Maximum_Sum_Circular_Subarray obj = new Q918_Maximum_Sum_Circular_Subarray();
        System.out.println(obj.maxSubarraySumCircular(new int[]{-2}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{3,-1,2,-1}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{3,-2,2,-3}));
        System.out.println(obj.maxSubarraySumCircular(new int[]{2,-2,2,7,8,0}));

    }
}
