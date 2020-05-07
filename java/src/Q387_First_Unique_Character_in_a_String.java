import java.util.ArrayList;
import java.util.List;

public class Q387_First_Unique_Character_in_a_String {

    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; ++i) {
            arr[i] = -1;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (arr[s.charAt(i) - 'a'] == -1)
                arr[s.charAt(i) - 'a'] = i;
            else
                arr[s.charAt(i) - 'a'] = -2;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 26; ++i) {
            if (arr[i] >= 0)
                list.add(arr[i]);
        }

        if (list.size() == 0) {
            return -1;
        }

        int min = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) < min)
                min = list.get(i);
        }

        return min;
    }

    public static void main(String[] args) {
        Q387_First_Unique_Character_in_a_String obj = new Q387_First_Unique_Character_in_a_String();
        System.out.println(obj.firstUniqChar("leetcode"));
    }
}
