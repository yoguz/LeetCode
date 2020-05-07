import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Q986_Interval_List_Intersections {

    public int[][] intervalIntersectionComplicated(int[][] A, int[][] B) {
        int Ai = 0, Bi = 0;
        List<Integer> list = new LinkedList<>();

        int i0 = -1, i1 = -1;
        while (Ai < A.length && Bi < B.length) {
            if (A[Ai][0] >= B[Bi][0] && A[Ai][0] <= B[Bi][1]) {
                i0 = A[Ai][0];
            } else if (B[Bi][0] >= A[Ai][0] && B[Bi][0] <= A[Ai][1]) {
                i0 = B[Bi][0];
            } else {
                i0 = -1;
            }

            if (A[Ai][1] >= B[Bi][0] && A[Ai][1] <= B[Bi][1]) {
                i1 = A[Ai][1];
            } else if (B[Bi][1] >= A[Ai][0] && B[Bi][1] <= A[Ai][1]) {
                i1 = B[Bi][1];
            } else {
                i1 = -1;
            }

            if (i0 != -1 && i1 != -1) {
                list.add(i0);
                list.add(i1);
            }

            if (A[Ai][1] == B[Bi][1]) {
                ++Ai;
                ++Bi;
            } else if (A[Ai][1] < B[Bi][1]) {
                ++Ai;
            }  else {
                ++Bi;
            }

        }

        int[][] result = new int[list.size()/2][2];

        ListIterator<Integer> listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            result[i][0] = listIterator.next();
            result[i][1] = listIterator.next();
            ++i;
        }
        return result;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Integer> list = new LinkedList<>();
        int i = 0, j = 0;
        while(i < A.length && j< B.length){

            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);

            if(start <= end) {
                list.add(start);
                list.add(end);
            }

            if (A[i][1] < B[j][1]) {
                ++i;
            }  else {
                ++j;
            }
        }

        int[][] result = new int[list.size()/2][2];

        ListIterator<Integer> listIterator = list.listIterator();
        int k = 0;
        while (listIterator.hasNext()) {
            result[k][0] = listIterator.next();
            result[k][1] = listIterator.next();
            ++k;
        }
        return result;
    }

    public static void main(String[] args) {
        Q986_Interval_List_Intersections obj = new Q986_Interval_List_Intersections();
        int[][] A  = new int[][] {
                {0,2}, {5,10}, {13,23}, {24,25}
        };

        int[][] B  = new int[][] {
                {1,5}, {8,12}, {15,24}, {25,26}
        };

        int[][] result = obj.intervalIntersection(A, B);

        for (int i = 0; i < result.length; ++i) {
            System.out.println("[" + result[i][0] + ", " + result[i][1] + "]");
        }
    }
}
