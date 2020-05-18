public class Q53_Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int res = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, res);
            if (nums[i] > res && res < 0)
                res = nums[i];
            else
                res += nums[i];
        }

        return Math.max(max, res);
    }

    public static void main(String[] args) {
        Q53_Maximum_Subarray obj = new Q53_Maximum_Subarray();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(obj.maxSubArray(new int[]{1,2}));
        System.out.println(obj.maxSubArray(new int[]{-1}));
        System.out.println(obj.maxSubArray(new int[]{2,1}));
        System.out.println(obj.maxSubArray(new int[]{1,-2}));
        System.out.println(obj.maxSubArray(new int[]{2,-1}));
    }
}
