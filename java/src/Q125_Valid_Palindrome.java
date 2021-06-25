public class Q125_Valid_Palindrome {

    public boolean isPalindromeOld(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char ci, cj;
        while (i < j) {
            try {
                ci = s.charAt(i);
                cj = s.charAt(j);


                while (!Character.isLetterOrDigit(ci)) {
                    i++;
                    ci = s.charAt(i);
                }

                while (!Character.isLetterOrDigit(cj)) {
                    j--;
                    cj = s.charAt(j);
                }
            } catch (Exception e) {
                return true;
            }

            ci = Character.toLowerCase(ci);
            cj = Character.toLowerCase(cj);

            if (ci != cj)
                return false;

            i++;
            j--;
        }

        return true;
    }

    public boolean isPalindrome_OnMemory(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                sb.append((char)(s.charAt(i)-'A'+'a'));
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                sb.append(s.charAt(i));
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                sb.append(s.charAt(i));
        }

        s = sb.toString();
        if (s.length() < 2)
            return true;
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Q125_Valid_Palindrome obj = new Q125_Valid_Palindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
    }
}
