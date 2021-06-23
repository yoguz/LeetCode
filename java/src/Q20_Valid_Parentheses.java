import java.util.Stack;

public class Q20_Valid_Parentheses {

    public boolean isValidOld(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                s.push(c);
            } else {
                if (s.isEmpty())
                    return false;

                char sc = s.peek();
                if ((sc == '(' && c == ')')
                        || (sc == '{' && c == '}')
                        || (sc == '[' && c == ']')) {
                    s.pop();
                } else
                    return false;
            }
        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        Q20_Valid_Parentheses obj = new Q20_Valid_Parentheses();
        System.out.println(obj.isValid("()"));
    }
}
