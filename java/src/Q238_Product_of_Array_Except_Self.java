public class Q238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            res[i] = 1;
        }

        int left = 1, right = nums[n-1];
        for (int i = 1; i < n; ++i) {
            res[i] *= nums[i-1] * left;
            left = res[i];
        }

        for (int i = n-2; i >= 0; --i) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Q238_Product_of_Array_Except_Self obj = new Q238_Product_of_Array_Except_Self();
        int []res = obj.productExceptSelf(new int[]{1,2,3,4,5});
        for (int i: res)
            System.out.print(i + ", ");
    }

}
