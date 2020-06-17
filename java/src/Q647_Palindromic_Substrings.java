public class Q647_Palindromic_Substrings {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += countOdd(s, i, 0);
        }
        for (int i = 0; i < s.length()-1; ++i) {
            count += countEven(s, i, 0);
        }
        return count;
    }

    private int countOdd(String s, int i, int w) {
        if (i-w < 0 || i+w == s.length())
            return 0;

        if (s.charAt(i-w) == s.charAt(i+w))
            return 1 + countOdd(s, i, w+1);

        return 0;
    }

    private int countEven(String s, int i, int w) {
        if (i-w < 0 || i+w == s.length()-1)
            return 0;

        if (s.charAt(i-w) == s.charAt(i+w+1))
            return 1 + countEven(s, i, w+1);

        return 0;
    }

    public static void main(String[] args) {
        Q647_Palindromic_Substrings obj = new Q647_Palindromic_Substrings();
        System.out.println(obj.countSubstrings("aa"));
        System.out.println(obj.countSubstrings("aaa"));
        System.out.println(obj.countSubstrings("aaaa"));
        System.out.println(obj.countSubstrings("aabb"));
    }
}
