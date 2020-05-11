public class Q75_Sort_Colors {

    public void sortColors2Pass(int[] nums) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) c0++;
            else if (nums[i] == 1) c1++;
            else c2++;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (c0 > 0){
                nums[i] = 0;
                c0--;
            } else if (c1 > 0){
                nums[i] = 1;
                c1--;
            } else {
                nums[i] = 2;
                c2--;
            }
        }
    }

    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }

    }

    public static void main(String[] args) {
        Q75_Sort_Colors obj = new Q75_Sort_Colors();
        int[] nums = new int[]{2,0,2,1,1,0};
        obj.sortColors(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}
