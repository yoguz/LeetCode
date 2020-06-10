public class Q394_Decode_String {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            } else {
                int count = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count = 10*count + (s.charAt(i) - '0');
                    i++;
                }
                StringBuilder sb2 = new StringBuilder();
                i++;
                int bracet = 1;
                while (true) {
                    if (s.charAt(i) == ']') {
                        bracet--;
                        if (bracet == 0) {
                            break;
                        }
                    } else if (s.charAt(i) == '[') {
                        bracet++;
                    }
                    sb2.append(s.charAt(i));
                    i++;
                }
                String sub = decodeString(sb2.toString());
                for (int j = 0; j < count; j++) {
                    sb.append(sub);
                }
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q394_Decode_String obj = new Q394_Decode_String();
        System.out.println(obj.decodeString("3[a]2[bc]"));
        System.out.println(obj.decodeString("3[a2[c]]"));
        System.out.println(obj.decodeString("2[abc]3[cd]ef"));
        System.out.println(obj.decodeString("abc3[cd]xyz"));
        System.out.println(obj.decodeString("100[leetcode]"));
    }
}
