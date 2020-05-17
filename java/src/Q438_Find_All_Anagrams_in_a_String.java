import java.util.ArrayList;
import java.util.List;

public class Q438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length())
            return res;

        int[] counts = new int[26];
        int[] maxCounts = new int[26];
        int total = p.length();
        for (int i = 0; i < p.length(); ++i) {
            counts[p.charAt(i) - 'a']++;
            maxCounts[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); ++i) {
            if (counts[s.charAt(i) - 'a'] > 0) {
                total--;
            }
            counts[s.charAt(i) - 'a']--;
        }

        if (total == 0)
            res.add(0);

        int removeIndex, addIndex;
        for (int i = 0; i < s.length() - p.length(); ++i) {
            removeIndex = s.charAt(i) - 'a';
            addIndex = s.charAt(i + p.length()) - 'a';
            if (counts[removeIndex] >=0 && counts[removeIndex] < maxCounts[removeIndex]) {
                total++;
            }
            counts[removeIndex] = Math.min(maxCounts[removeIndex], ++counts[removeIndex]);

            if (counts[addIndex] > 0) {
                total--;
            }
            counts[addIndex]--;

            if (total == 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q438_Find_All_Anagrams_in_a_String obj = new Q438_Find_All_Anagrams_in_a_String();
        List<Integer> result = obj.findAnagrams("cbaebabacd", "abc");
        for (Integer i : result)
            System.out.print(i + " ");
        System.out.println();
        result = obj.findAnagrams("abab", "ab");
        for (Integer i : result)
            System.out.print(i + " ");
        System.out.println();
    }
}
