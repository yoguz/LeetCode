public class Q26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int i = 0, count = 1;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                count++;
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Q26_Remove_Duplicates_from_Sorted_Array obj = new Q26_Remove_Duplicates_from_Sorted_Array();
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = obj.removeDuplicates(arr);
        System.out.println(res);
        for(int i: arr) {
            if (res == 0)
                break;
            System.out.print(i + ", ");
            res--;
        }
    }
}
