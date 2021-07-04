public class Q213_House_Robber_II {

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int max1 = 0, max2 = 0, n = nums.length;

        int prev2 = nums[0], prev1 = nums[1];
        max1 = Math.max(prev2, prev1);
        prev1 = max1;
        for (int i = 2; i < n - 1; ++i) {
            max1 = Math.max(nums[i] + prev2, max1);
            prev2 = prev1;
            prev1 = max1;
        }

        prev2 = nums[n-1]; prev1 = nums[n-2];
        max2 = Math.max(prev2, prev1);
        prev1 = max2;
        for (int i = n - 3; i > 0; --i) {
            max2 = Math.max(nums[i] + prev2, max2);
            prev2 = prev1;
            prev1 = max2;
        }

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        Q213_House_Robber_II obj = new Q213_House_Robber_II();
        //System.out.println(obj.rob(new int[]{1,2,3,1}));
        //System.out.println(obj.rob(new int[]{1,100,200,200}));
        System.out.println(obj.rob(new int[]{1,3,1,3,100}));
    }
}
