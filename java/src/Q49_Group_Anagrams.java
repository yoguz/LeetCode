import java.util.*;

public class Q49_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0)
            return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        map.forEach((k, v) -> res.add(v));
        return res;
    }

    public List<List<String>> groupAnagramsBetter(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Q49_Group_Anagrams obj = new Q49_Group_Anagrams();
        List<List<String>> res = obj.groupAnagramsBetter(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> elem : res) {
            for (String i : elem)
                System.out.print(i + ", ");
            System.out.println();
        }
    }
}
