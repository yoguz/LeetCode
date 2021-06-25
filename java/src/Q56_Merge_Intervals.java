import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56_Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int idx = 1; idx < intervals.length; ++idx) {
            if (intervals[idx][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[idx][0];
                end = intervals[idx][1];
            } else {
                end = Math.max(end, intervals[idx][1]);
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Q56_Merge_Intervals obj = new Q56_Merge_Intervals();
        int[][] intervals = new int[][] {
                {1,3},{2,6},{8,10},{15,18}
        };

        int[][] result = obj.merge(intervals);
        for (int[] merged: result)
            System.out.println(Arrays.toString(merged));
    }
}
