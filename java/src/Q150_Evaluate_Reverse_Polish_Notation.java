import java.util.Stack;

public class Q150_Evaluate_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i1, i2, res = 0;
        for (String s: tokens) {
            if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.length() > 1) {
                stack.push(Integer.parseInt(s));
            } else {
                i2 = stack.pop();
                i1 = stack.pop();
                switch(s.charAt(0)) {
                    case '+':
                        res = i1+i2;
                        break;
                    case '-':
                        res = i1-i2;
                        break;
                    case '*':
                        res = i1*i2;
                        break;
                    case '/':
                        res = i1/i2;
                        break;
                }
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Q150_Evaluate_Reverse_Polish_Notation obj = new Q150_Evaluate_Reverse_Polish_Notation();
        System.out.println(obj.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
