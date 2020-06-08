public class Q231_Power_of_Two {

    public boolean isPowerOfTwo_O1(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }

    public boolean isPowerOfTwo_Ologn_Recursive(int n) {
        return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo_Ologn_Recursive(n/2)));
    }

    public boolean isPowerOfTwo_Ologn_Iterative(int n) {
        if (n <= 0) return false;
        while (n%2 == 0) n/=2;
        return n == 1;
    }

    public static void main(String[] args) {
        Q231_Power_of_Two obj = new Q231_Power_of_Two();
        System.out.println(obj.isPowerOfTwo_O1(1024));
        System.out.println(obj.isPowerOfTwo_Ologn_Iterative(12345));
        System.out.println(obj.isPowerOfTwo_Ologn_Recursive(65536));
    }
}
