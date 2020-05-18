public class Q567_Permutation_in_String {

    public boolean checkInclusion(String p, String s) {
        if (p.length() > s.length())
            return false;

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
            return true;

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
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q567_Permutation_in_String obj = new Q567_Permutation_in_String();
        System.out.println(obj.checkInclusion("ab", "eidbaooo"));
        System.out.println(obj.checkInclusion("ab", "eidboaooo"));
    }
}
