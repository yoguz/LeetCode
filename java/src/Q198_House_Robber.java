public class Q198_House_Robber {

    public int robOld(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        nums[2] += nums[0];
        for (int i = 3; i < nums.length; ++i) {
            nums[i] += Math.max(nums[i-2], nums[i-3]);
        }

        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        Q198_House_Robber obj = new Q198_House_Robber();
        System.out.println(obj.rob(new int[]{1,4,2,7,8,2,5,14,22,6,8,33,14,2,55}));
    }
}
