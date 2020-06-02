public class Q33_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target))
            return -1;
        else if (nums.length == 1 && nums[0] == target)
            return 0;

        int lo = 0, hi = nums.length, mid = 0;
        if (nums[lo] < nums[hi-1])
            mid = 0;
        else
            while (lo < hi) {
                mid = lo + (hi - lo) / 2;
                if (nums[mid-1] > nums[mid])
                    break;
                else {
                    if (nums[lo] > nums[mid])
                        hi = mid;
                    else
                        lo = mid;
                }
            }

        if (target == nums[mid])
            return mid;

        else if (target <= nums[nums.length-1]) {
            lo = mid;
            hi = nums.length;
        } else {
            lo = 0;
            hi = mid;
        }

        while (lo < hi) {
            mid = lo + (hi-lo) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                lo = mid+1;
            else
                hi = mid-1;
        }
        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        Q33_Search_in_Rotated_Sorted_Array obj = new Q33_Search_in_Rotated_Sorted_Array();
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 5));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 6));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 7));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 2));
        System.out.println(obj.search(new int[]{4,6,0,1,2,3}, 5));
        System.out.println(obj.search(new int[]{1,3}, 2));

    }
}
