import java.util.Stack;

public class Q20_Valid_Parentheses {

    public boolean isValid(String s) {
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

    public static void main(String[] args) {
        Q20_Valid_Parentheses obj = new Q20_Valid_Parentheses();
        System.out.println(obj.isValid("()"));
    }
}
