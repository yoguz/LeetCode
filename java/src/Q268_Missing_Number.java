public class Q268_Missing_Number {

    public int missingNumber(int[] nums) {
        long sum = 0;
        for (int i: nums)
            sum += i;

        long actual = ((nums.length+1) * nums.length) / 2;
        return (int)(actual-sum);
    }

    public static void main(String[] args) {
        Q268_Missing_Number obj = new Q268_Missing_Number();
        System.out.println(obj.missingNumber(new int[]{0,1,2,3,4,6,7}));
    }
}
