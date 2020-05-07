import java.util.HashSet;
import java.util.Set;

public class Q771_Jewels_and_Stones {

    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }

        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); ++i) {
            jewels.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (jewels.contains(S.charAt(i)))
                ++count;
        }

        return count;
    }

    public static void main(String[] args) {
        Q771_Jewels_and_Stones obj = new Q771_Jewels_and_Stones();
        String J = "abCcfFI";
        String S = "asflkjqhwpodgkzljkxvQPOIWEFHSLMNVBZSLELKRBJÖMXCNVQWEJKASJFKDAasfjhasjkdfhJ";
        System.out.println(obj.numJewelsInStones(J, S));
    }
}
