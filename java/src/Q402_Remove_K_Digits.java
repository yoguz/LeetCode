public class Q402_Remove_K_Digits {

    public String removeKdigits2(String num, int k) {
        if (num.length() == k)
            return "0";

        int idx;
        String newNum;
        for (int i = 0; i < k; ++i) {
            idx = 0;
            while (idx < num.length()-1) {
                if (num.charAt(idx) <= num.charAt(idx+1))
                    idx++;
                else
                    break;
            }

            newNum = "";
            if (idx > 0)
                newNum = num.substring(0, idx);
            if (idx < num.length()-1)
                newNum += num.substring(idx+1);
            num = newNum;
        }

        return trim(num);
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        int idx;
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; ++i) {
            idx = 0;
            while (idx < sb.length()-1) {
                if (sb.charAt(idx) <= sb.charAt(idx+1))
                    idx++;
                else
                    break;
            }

            sb.deleteCharAt(idx);
        }

        return trim(sb.toString());
    }

    private String trim(String s) {
        int nonZeroIdx = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '0') {
                nonZeroIdx = i;
                break;
            }
        }
        if (nonZeroIdx == -1)
            return "0";
        else
            return s.substring(nonZeroIdx);
    }

    public static void main(String[] args) {
        Q402_Remove_K_Digits obj = new Q402_Remove_K_Digits();
        System.out.println(obj.removeKdigits("5337", 2));
        System.out.println(obj.removeKdigits("1432219", 3));
        System.out.println(obj.removeKdigits("10200", 1));
        System.out.println(obj.removeKdigits("10", 2));
    }
}
