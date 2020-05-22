import java.util.*;

public class Q451_Sort_Characters_By_Frequency {

    class Count {
        char c;
        int i;
        Count(char _c, int _i) {
            this.c = _c;
            this.i = _i;
        }
    }

    class CountComparator implements Comparator<Count> {
        public int compare(Count a, Count b) {
            return b.i-a.i;
        }
    }

    public String frequencySort(String s) {
        if (s.length() == 0)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        List<Count> counts = new ArrayList<>();
        map.forEach((k,v) -> counts.add(new Count(k, v)));
        Collections.sort(counts, new CountComparator());

        StringBuilder sb = new StringBuilder();
        for (Count c: counts) {
            for (int i = 0; i < c.i; ++i) {
                sb.append(c.c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Q451_Sort_Characters_By_Frequency obj = new Q451_Sort_Characters_By_Frequency();
        System.out.println(obj.frequencySort("tree"));
        System.out.println(obj.frequencySort("cccaaa"));
        System.out.println(obj.frequencySort("Aabb"));
    }
}
