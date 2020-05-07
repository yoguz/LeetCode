public class Q278_First_Bad_Version {
    public int firstBadVersion(int n) {
        if (n == 1)
            return 1;

        long low = 1, high = n, mid = 0;
        while (low < (high - 1)) {
            mid = (low + high) / 2;

            if (isBadVersion((int)mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return isBadVersion((int)low) ? (int)low : (int)high;

    }

    private boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static void main(String[] args) {
        Q278_First_Bad_Version obj = new Q278_First_Bad_Version();
        int result = obj.firstBadVersion(2126753390);
        System.out.println(result);
    }
}
