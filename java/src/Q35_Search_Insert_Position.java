public class Q35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        int lo = 0, hi = nums.length-1, mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return target <= nums[lo] ? lo : lo+1;
    }

    public static void main(String[] args) {
        Q35_Search_Insert_Position obj = new Q35_Search_Insert_Position();
        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 0));
    }
}
