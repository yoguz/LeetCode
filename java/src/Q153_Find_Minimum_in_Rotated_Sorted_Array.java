public class Q153_Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] nums, int l, int r) {
        if (r - l <= 1)
            return Math.min(nums[l], nums[r]);

        int m = (l+r) / 2;

        if (nums[m] > nums[l] && nums[r] > nums[m])
            return nums[l];
        else if (nums[m] > nums[l] && nums [m] > nums[r])
            return helper(nums, m, r);
        else
            return helper(nums, l, m);
    }

    public static void main(String[] args) {
        Q153_Find_Minimum_in_Rotated_Sorted_Array obj = new Q153_Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(obj.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(obj.findMin(new int[]{3,4,5,1,2}));
        System.out.println(obj.findMin(new int[]{0,1,2,3,4,5}));
    }
}
