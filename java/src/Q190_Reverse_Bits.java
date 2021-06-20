public class Q190_Reverse_Bits {

    public int reverseBits(int n) {
        int N = n;
        int res = 0;
        int i = 0;
        n &= Integer.MAX_VALUE;

        while (n != 0) {
            res += n % 2;
            res = res << 1;
            n = n >> 1;
            ++i;
        }

        while (32 - (++i) > 0) {
            res = res << 1;
        }

        if (N < 0)
            res |= 1;

        return res;
    }

    public static void main(String[] args) {
        Q190_Reverse_Bits obj = new Q190_Reverse_Bits();
        System.out.println(obj.reverseBits(43261596));
        System.out.println(obj.reverseBits(-1));
    }
}
