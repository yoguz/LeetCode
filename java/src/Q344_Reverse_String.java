public class Q344_Reverse_String {

    public void reverseString(char[] s) {
        int n = s.length;
        char temp;
        for (int i = 0; i < n/2; ++i) {
            temp = s[n-i-1];
            s[n-i-1] = s[i];
            s[i] = temp;
        }
    }

    public static void main(String[] args) {
        Q344_Reverse_String obj = new Q344_Reverse_String();
        char[] s = new char[]{'a', 'b', 'c' , 'd'};
        obj.reverseString(s);
        for (char c: s)
            System.out.print(c + ", ");

        System.out.println();
        s = new char[]{'a', 'b', 'c'};
        obj.reverseString(s);
        for (char c: s)
            System.out.print(c + ", ");
    }

}
