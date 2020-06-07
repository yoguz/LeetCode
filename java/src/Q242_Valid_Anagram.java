public class Q242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] c = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            c[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); ++i) {
            c[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < c.length; ++i) {
            if (c[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Q242_Valid_Anagram obj = new Q242_Valid_Anagram();
        System.out.println(obj.isAnagram("anagram", "aamragn"));
        System.out.println(obj.isAnagram("oguzhan", "anghanu"));
    }
}
