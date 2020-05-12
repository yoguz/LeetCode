public class Q540_Single_Element_in_a_Sorted_Array {

    public int singleNonDuplicate(int[] nums) {
        return nums[helper(nums, 0, nums.length-1)];
    }

    private int helper(int[] nums, int lo, int hi) {
        if (lo == hi)
            return lo;
        else if (lo == hi-2)
        {
            if (nums[lo] == nums[lo+1])
                return hi;
            else return lo;
        }

        int mid = (lo+hi)/2;
        if (mid == 0)
            return 0;
        else if (mid == nums.length-1)
            return nums.length-1;
        else {
            if (nums[mid] == nums[mid-1] && (mid-lo)%2 == 0)
                return helper(nums, lo, mid);
            else if (nums[mid] == nums[mid-1] && (mid-lo)%2 == 1)
                return helper(nums, mid-1, hi);
            else if (nums[mid] == nums[mid+1]  && (hi-mid)%2 == 0)
                return helper(nums, mid, hi);
            else if (nums[mid] == nums[mid+1]  && (hi-mid)%2 == 1)
                return helper(nums, lo, mid+1);
            else
                return mid;
        }
    }

    public static void main(String[] args) {
        Q540_Single_Element_in_a_Sorted_Array obj = new Q540_Single_Element_in_a_Sorted_Array();
        int[] arr = new int[]{2,1,1,3,3,4,4,5,5};
        System.out.println(obj.singleNonDuplicate(arr));
        arr = new int[]{1,1,2};
        System.out.println(obj.singleNonDuplicate(arr));
        arr = new int[]{1,1,2,2,3};
        System.out.println(obj.singleNonDuplicate(arr));
        arr = new int[]{1,1,2,2,3,4,4};
        System.out.println(obj.singleNonDuplicate(arr));
        arr = new int[]{1};
        System.out.println(obj.singleNonDuplicate(arr));
    }
}
