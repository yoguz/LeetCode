public class Q66_Plus_One {

    public int[] plusOne_2Pass(int[] digits) {
        boolean allNine = true;
        for (int i: digits)
            if (i != 9) {
                allNine = false;
                break;
            }

        if (allNine) {
            int[] arr = new int[digits.length+1];
            arr[0] = 1;
            return arr;
        } else {
            int[] arr = new int[digits.length];
            int j = 1;
            for (int i = digits.length-1; i >= 0; --i) {
                if (digits[i] + j == 10)
                    arr[i] = 0;
                else {
                    arr[i] = digits[i]+j;
                    j = 0;
                }
            }
            return arr;
        }

    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        Q66_Plus_One obj = new Q66_Plus_One();
        int[] res = obj.plusOne(new int[]{1,2,3,9});
        for (int i: res)
            System.out.print(i);
        System.out.println();
        res = obj.plusOne(new int[]{9,9,9});
        for (int i: res)
            System.out.print(i);
        System.out.println();
    }
}
