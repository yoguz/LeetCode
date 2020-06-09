public class Q392_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length())
            return false;

        int j = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (j == s.length())
                return true;
            else if (s.charAt(j) == t.charAt(i))
                j++;
        }

        return j == s.length();
    }

    public static void main(String[] args) {
        Q392_Is_Subsequence obj = new Q392_Is_Subsequence();
        System.out.println(obj.isSubsequence("algo", "tpawılbgo"));
        System.out.println(obj.isSubsequence("algo", "tolga"));
    }
}
