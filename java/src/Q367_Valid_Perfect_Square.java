public class Q367_Valid_Perfect_Square {

    public boolean isPerfectSquareON(int num) {
        long i = 1;
        while (i * i < Integer.MAX_VALUE) {
            if (i * i == num)
                return true;
            i++;
        }

        return false;
    }

    public boolean isPerfectSquare(int num) {
        // 1  = 1
        // 4  = 1 + 3
        // 9  = 1 + 3 + 5
        // 16 = 1 + 3 + 5 + 7
        // 25 = 1 + 3 + 5 + 7 + 9
        // n^2= sum(1..n) (2n-1)

        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }

        return 0 == num;
    }

    public static void main(String[] args) {
        Q367_Valid_Perfect_Square obj = new Q367_Valid_Perfect_Square();
        System.out.println(obj.isPerfectSquare(1));
        System.out.println(obj.isPerfectSquare(4));
        System.out.println(obj.isPerfectSquare(9));
        System.out.println(obj.isPerfectSquare(1665));
        System.out.println(obj.isPerfectSquare(1024));
        System.out.println(obj.isPerfectSquare(2500));
    }
}
