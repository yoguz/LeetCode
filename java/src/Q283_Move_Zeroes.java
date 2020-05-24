public class Q283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        int nonZero = 0, zero = 0;
        while (nonZero < nums.length && zero < nums.length) {
            if (nums[zero] != 0) {
                zero++;
                continue;
            }

            if (nums[nonZero] == 0) {
                nonZero++;
                continue;
            }

            if (nonZero > zero) {
                nums[zero] = nums[nonZero];
                nums[nonZero] = 0;
                zero++;
                nonZero++;
            } else {
                nonZero = zero + 1;
            }
        }
    }

    public static void main(String[] args) {
        Q283_Move_Zeroes obj = new Q283_Move_Zeroes();
        int[] arr = new int[]{1,2,3};
        obj.moveZeroes(arr);
        printArr(arr);
        arr = new int[]{1};
        obj.moveZeroes(arr);
        printArr(arr);
        arr = new int[]{0};
        obj.moveZeroes(arr);
        printArr(arr);
        arr = new int[]{0,0,0,0};
        obj.moveZeroes(arr);
        printArr(arr);
        arr = new int[]{1,0,0,0};
        obj.moveZeroes(arr);
        printArr(arr);
        arr = new int[]{0,1,0,3,4};
        obj.moveZeroes(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        System.out.println();

        for (int i: arr) {
            System.out.print(i + ",");
        }
    }
}
