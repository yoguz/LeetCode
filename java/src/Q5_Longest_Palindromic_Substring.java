public class Q5_Longest_Palindromic_Substring {

    public String longestPalindromeOld(String s) {
        if (s.length() < 2)
            return s;

        String max = "" + s.charAt(0), cur;
        for (int i = 1; i < s.length()-1; ++i) {
            cur = palindromeOdd(s, i);
            max = cur.length() > max.length() ? cur : max;
        }

        for (int i = 0; i < s.length()-1; ++i) {
            cur = palindromeEven(s, i);
            max = cur.length() > max.length() ? cur : max;
        }

        return max;
    }

    private String palindromeOdd(String s, int i) {
        String res = "" + s.charAt(i);
        int inc = 1;
        while (i - inc >= 0 && i + inc < s.length() && s.charAt(i-inc) == s.charAt(i+inc)) {
            res = s.charAt(i-inc) + res + s.charAt(i-inc);
            inc++;
        }

        return res;
    }

    private String palindromeEven(String s, int i) {
        if (s.charAt(i) != s.charAt(i+1))
            return "";

        String res = "" + s.charAt(i) + s.charAt(i);
        int inc = 1;
        while (i - inc >= 0 && i + inc + 1 < s.length() && s.charAt(i-inc) == s.charAt(i+inc+1)) {
            res = s.charAt(i-inc) + res + s.charAt(i-inc);
            inc++;
        }

        return res;
    }

    public String longestPalindromeWorse(String s) {
        String longestOdd = "", longestEven = "";

        int start = 0, end = 0, max = 1;

        for (int i = 0; i < s.length(); ++i) {
            int j = 1;
            while (i - j >= 0 && i + j < s.length()) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    if (2*j+1 > max) {
                        max = 2*j+1;
                        start = i-j;
                        end = i+j;
                    }
                } else {
                    break;
                }
                j++;
            }
        }

        longestOdd = s.substring(start, end+1);
        start = 0; end = 0; max = 0;

        for (int i = 0; i < s.length()-1; ++i) {
            int j = 0;
            while (i - j >= 0 && i + j + 1 < s.length()) {
                if (s.charAt(i-j) == s.charAt(i+j+1)) {
                    if (2*j+2 > max) {
                        max = 2*j+2;
                        start = i-j;
                        end = i+j+1;
                    }
                } else {
                    break;
                }
                j++;
            }
        }

        longestEven = s.substring(start, end+1);

        return longestOdd.length() > longestEven.length() ? longestOdd : longestEven;
    }

    public String longestPalindrome(String s) {
        int center = 0, max = 1;
        int oddLength = 0, evenLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            oddLength = extend(s, i, i);
            evenLength = extend(s, i, i+1);

            int newMax = Math.max(max, Math.max(oddLength, evenLength));
            if (newMax != max) {
                center = i;
                max = newMax;
            }
        }

        return s.substring(center - (max - 1) / 2, center + max / 2 + 1);
    }

    private int extend(String s, int start, int end) {
        int width = 0;
        while (start - width >= 0 && end + width < s.length()) {
            if (s.charAt(start-width) == s.charAt(end+width)) {
                width++;
            } else {
                break;
            }
        }

        return end - start + (2 * width) - 1;
    }

    public static void main(String[] args) {
        Q5_Longest_Palindromic_Substring obj = new Q5_Longest_Palindromic_Substring();
        System.out.println(obj.longestPalindrome("aa"));
        System.out.println(obj.longestPalindrome("be"));

        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("cddb"));
        System.out.println(obj.longestPalindrome("fffgggee"));
        System.out.println(obj.longestPalindrome("abcdcbaef"));


    }
}
