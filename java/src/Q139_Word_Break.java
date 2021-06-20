import java.util.*;

public class Q139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] breaks = new boolean[n+1];

        breaks[0] = true;

        for (int i = 1; i < n+1; ++i) {
            if (breaks[i])
                continue;

            for (String str: wordDict) {
                int start = i - str.length();
                if (start >= 0 && breaks[start] && s.substring(start, i).equals(str)) {
                    breaks[i] = true;
                    break;
                }
            }
        }

        return breaks[n];
    }

    public static void main(String[] args) {
        Q139_Word_Break obj = new Q139_Word_Break();
        System.out.println(obj.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(obj.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));
    }

}
