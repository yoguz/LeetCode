import java.util.Arrays;

public class Q1029_Two_City_Scheduling {

    public int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        int[] diffs = new int[costs.length];

        for (int i = 0; i < costs.length; ++i) {
            cost += costs[i][0];
            diffs[i] = costs[i][1] - costs[i][0];
        }

        Arrays.sort(diffs);

        for (int i = 0; i < costs.length/2; ++i) {
            cost += diffs[i];
        }

        return cost;
    }

    public static void main(String[] args) {
        Q1029_Two_City_Scheduling obj = new Q1029_Two_City_Scheduling();
        System.out.println(obj.twoCitySchedCost(new int[][]{{10,20}, {30,200}, {400,50}, {30,20}}));
        System.out.println(obj.twoCitySchedCost(new int[][]{{1,1000}, {1000,1}}));
    }
}
