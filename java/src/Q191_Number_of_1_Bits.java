public class Q191_Number_of_1_Bits {

    public int hammingWeight(int n) {
        int res = 0;
        if (n == 0)
            return res;
        else if (n > 0) {
            while (n > 0) {
                res += n%2;
                n /= 2;
            }
        } else {
            while (n < -1) {
                res += n%2 == 0 ? 1 : 0;
                n = n >> 1;
            }
            res = 32 - res;
        }
        return res;

    }

    public static void main(String[] args) {
        Q191_Number_of_1_Bits obj = new Q191_Number_of_1_Bits();
        System.out.println(obj.hammingWeight(-3));
        System.out.println(obj.hammingWeight(1));
        System.out.println(obj.hammingWeight(-1));
        System.out.println(obj.hammingWeight(-2));
        System.out.println(obj.hammingWeight(2));
        System.out.println(obj.hammingWeight(-3));
        System.out.println(obj.hammingWeight(3));

    }
}
