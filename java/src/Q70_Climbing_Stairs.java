public class Q70_Climbing_Stairs {

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;

        int step = 0, step1 = 2, step2 = 1;

        for (int i = n-3; i >= 0; --i) {
            step = step1 + step2;
            step2 = step1;
            step1 = step;
        }

        return step;
    }

    public static void main(String[] args) {
        Q70_Climbing_Stairs obj = new Q70_Climbing_Stairs();
        System.out.println(obj.climbStairs(10));
        System.out.println(obj.climbStairs(20));
        System.out.println(obj.climbStairs(30));
        System.out.println(obj.climbStairs(40));
    }
}
