import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q792_Number_of_Matching_Subsequences {

    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            if (!map.containsKey(S.charAt(i)))
                map.put(S.charAt(i), new ArrayList<>());
            map.get(S.charAt(i)).add(i);
        }

        int count = 0, index;
        for (String word: words) {
            index = findSmallestNumber(map.get(word.charAt(0)), -1);
            if (index == -1)
                continue;

            for (int i = 1; i < word.length(); ++i) {
                index = findSmallestNumber(map.get(word.charAt(i)), index);
                if (index == -1)
                    break;
            }

            if (index != -1)
                count++;
        }

        return count;
    }

    private int findSmallestNumber_On(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        if (target == -1)
            return list.get(0);

        for (int i: list) {
            if (i > target)
                return i;
        }
        return -1;
    }

    private int findSmallestNumber(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        if (target == -1)
            return list.get(0);

        int start = 0, end = list.size() - 1, mid;
        int ans = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (list.get(mid) <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans == -1 ? -1 : list.get(ans);
    }

    public static void main(String[] args) {
        Q792_Number_of_Matching_Subsequences obj = new Q792_Number_of_Matching_Subsequences();
        System.out.println(obj.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
