import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q901_Online_Stock_Span {

    class Stock {
        int price;
        int span;

        Stock(int p, int s) {
            this.price = p;
            this.span = s;
        }
    }

    /*
    // With ArrayList
    List<Stock> list;
    public Q901_Online_Stock_Span() {
        list = new ArrayList();
    }

    public int next(int price) {
        int index = list.size()-1;
        while (index >= 0 && list.get(index).price <= price) {
            index -= list.get(index).span;
        }
        int span = list.size() - index;
        list.add(new Stock(price, span));
        return span;
    }
    */

    // With Stack
    Stack<Stock> stack;
    public Q901_Online_Stock_Span() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek().price <= price)
            res += stack.pop().span;
        stack.push(new Stock(price, res));
        return res;
    }

    public static void main(String[] args) {
        Q901_Online_Stock_Span obj = new Q901_Online_Stock_Span();
        int[] prices = new int[]{100,80,60,70,60,75,85};
        for (Integer price: prices) {
            System.out.println(obj.next(price));
        }
    }
}
