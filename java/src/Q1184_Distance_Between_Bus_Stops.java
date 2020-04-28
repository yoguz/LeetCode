public class Q1184_Distance_Between_Bus_Stops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;

        int n1 = Math.min(start, destination);
        int n2 = Math.max(start, destination);
        int d1 = 0, d2 = 0;

        for (int i = n1; i < n2; ++i) {
            d1 += distance[i];
        }

        if (n1 > 0) {
            for (int i = n1 - 1; i >= 0; --i) {
                d2 += distance[i];
            }
        }

        for (int i = distance.length - 1; i >= n2; --i) {
            d2 += distance[i];
        }

        return Math.min(d1, d2);
    }

    public static void main(String[] args) {
        Q1184_Distance_Between_Bus_Stops obj = new Q1184_Distance_Between_Bus_Stops();
        int distance[] = new int[]{1,2,3,4};
        System.out.println(obj.distanceBetweenBusStops(distance, 0, 3));
    }
}
