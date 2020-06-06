import java.util.ArrayList;
import java.util.List;

public class Q57_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            list.add(newInterval);
            return list.toArray(new int[0][]);
        }

        int start = newInterval[0] < intervals[0][0] ? newInterval[0] : -1;
        int end = newInterval[1] < intervals[0][0] ? newInterval[0] : -1;
        boolean isAdded = false;
        if (start != -1 && end != -1) {
            list.add(newInterval);
            isAdded = true;
        }
        for (int[] i: intervals) {
            if (start == -1 && newInterval[0] >= i[0] && newInterval[0] <= i[1])
                start = i[0];
            else if (start == -1 && newInterval[0] < i[0])
                start = newInterval[0];

            if (end == -1 && newInterval[1] >= i[0] && newInterval[1] <= i[1])
                end = i[1];
            else if (end == -1 &&  newInterval[1] < i[1])
                end = newInterval[1];

            if (start != -1 && end != -1 && !isAdded) {
                list.add(new int[]{start, end});
                isAdded = true;
                if (end >= i[0])
                    continue;
            }

            if ((start == -1 && end == -1) || isAdded)
                list.add(i);
        }

        if (end == -1)
            list.add(new int[]{start == -1 ? newInterval[0] : start, newInterval[1]});

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Q57_Insert_Interval obj = new Q57_Insert_Interval();
        int[][] res = obj.insert(new int[][] {{2,3}, {4,5}, {6,7}, {8,10}, {12,16}}, new int[]{0,1});
        for (int[] i : res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
        System.out.println();
        res = obj.insert(new int[][] {{2,3}, {4,5}, {6,7}, {8,10}, {12,16}}, new int[]{0,100});
        for (int[] i : res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
        System.out.println();
        res = obj.insert(new int[][] {{2,3}, {4,5}, {6,7}, {8,10}, {12,16}}, new int[]{0,3});
        for (int[] i : res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
        System.out.println();
        res = obj.insert(new int[][] {{2,3}, {4,5}, {6,7}, {8,10}, {12,16}}, new int[]{3,9});
        for (int[] i : res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
        System.out.println();
        res = obj.insert(new int[][] {{2,3}, {4,5}, {6,7}, {8,10}, {12,16}}, new int[]{3,17});
        for (int[] i : res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
        System.out.println();
        res = obj.insert(new int[][] {{2,3}, {4,5}, {6,7}, {10,11}, {12,16}}, new int[]{8,9});
        for (int[] i : res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
        System.out.println();
    }
}
