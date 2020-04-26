import java.util.Arrays;

public class Q997_Squares_of_a_Sorted_Array {
    public int[] badSortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares(int[] A) {
        if (A.length == 0)
            return A;
        else if (A.length == 1) {
            A[0] *= A[0];
            return A;
        }

        for (int i = 0; i < A.length; ++i) {
            A[i] = A[i] * A[i];
        }


        if (A.length == 2) {
            if (A[0] > A[1])
                swap(A, 0, 1);
            return A;
        } else {
            int minIndex = 0;
            for (int i = 1; i < A.length; ++i) {
                if (A[i] <= A[minIndex])
                    minIndex = i;
                else
                    break;
            }

            if (minIndex == 0) {
                return A;
            }

            int[] x = new int[A.length];
            x[0] = A[minIndex];
            int index = 1, i = minIndex-1, j = minIndex+1;
            while(i >= 0 && j < A.length) {
                if (A[i] <= A[j]) {
                    x[index] = A[i];
                    i--;
                } else {
                    x[index] = A[j];
                    j++;
                }
                index++;
            }

            while(i >= 0) {
                x[index] = A[i];
                i--;
                index++;
            }

            while(j < A.length) {
                x[index] = A[j];
                j++;
                index++;
            }

            return x;
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-3,-3,-2,1};
        Q997_Squares_of_a_Sorted_Array obj = new Q997_Squares_of_a_Sorted_Array();
        obj.sortedSquares(A);
    }
}
