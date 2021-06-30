import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q295_Find_Median_from_Data_Stream {

    Queue<Integer> less = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> more = new PriorityQueue<>();

    boolean equal;
    /** initialize your data structure here. */
    public Q295_Find_Median_from_Data_Stream() {
        equal = true;
    }

    public void addNum(int num) {
        if (equal) {
            if (less.isEmpty() || less.peek() >= num) {
                less.add(num);
            } else {
                more.add(num);
            }
        } else {
            if (less.size() > more.size() && less.peek() >= num) {
                more.add(less.poll());
            } else if (less.size() < more.size() && more.peek() <= num) {
                less.add(more.poll());
            }

            if (less.size() > more.size()) {
                more.add(num);
            } else {
                less.add(num);
            }
        }

        equal = !equal;
    }

    public double findMedian() {
        if (equal) {
            return (less.peek() + more.peek()) * 1.0 / 2;
        } else {
            return less.size() > more.size() ? less.peek() : more.peek();
        }
    }

    public static void main(String[] args) {
        Q295_Find_Median_from_Data_Stream obj = new Q295_Find_Median_from_Data_Stream();
        obj.addNum(10);
        obj.addNum(6);
        obj.addNum(20);
        System.out.println(obj.findMedian());
        obj.addNum(15);
        obj.addNum(30);
        obj.addNum(100);
        System.out.println(obj.findMedian());
    }
}
