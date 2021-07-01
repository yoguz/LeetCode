import java.util.HashMap;
import java.util.Map;

public class Q3_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstringOld(String s) {
        if (s.length() < 2)
            return s.length();

        int lo = 0, hi = 1, max = 1;
        Map<Character, Integer> indexes = new HashMap<>();

        indexes.put(s.charAt(0), 0);

        while (hi < s.length()) {
            if (indexes.containsKey(s.charAt(hi)) && indexes.get(s.charAt(hi)) >= lo) {
                lo = indexes.get(s.charAt(hi)) + 1;
            }
            indexes.put(s.charAt(hi), hi);
            hi++;
            max = Math.max(max, hi-lo);
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[256];
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (counts[c] == 0) {
                counts[c]++;
                max = Math.max(max, right-left+1);
                right++;
            } else {
                while (counts[c] > 0) {
                    char toDelete = s.charAt(left);
                    counts[toDelete]--;
                    left++;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Q3_Longest_Substring_Without_Repeating_Characters obj = new Q3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("     "));
        System.out.println(obj.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("abcdef"));
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));
    }
}
