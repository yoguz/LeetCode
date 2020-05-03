public class Q383_Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.isEmpty())
            return true;

        if(magazine == null || magazine.isEmpty())
            return false;

        int[] ransomCount = new int[26];
        for (int i = 0; i  < ransomNote.length(); ++i) {
            ransomCount[ransomNote.charAt(i)-'a']++;
        }

        int[] magazineCount = new int[26];
        for (int i = 0; i  < magazine.length(); ++i) {
            magazineCount[magazine.charAt(i)-'a']++;
        }

        for(int i = 0; i < ransomCount.length; ++i) {
            ransomCount[i] -= magazineCount[i];
            if (ransomCount[i] > 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Q383_Ransom_Note obj = new Q383_Ransom_Note();
        System.out.println(obj.canConstruct("a", "b"));
        System.out.println(obj.canConstruct("aa", "ab"));
        System.out.println(obj.canConstruct("aa", "aab"));
    }
}
