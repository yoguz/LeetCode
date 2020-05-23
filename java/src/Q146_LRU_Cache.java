import java.util.HashMap;
import java.util.Map;

public class Q146_LRU_Cache {

    class DNode {
        DNode prev;
        DNode next;
        int key;
        int value;

        DNode(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    int capacity;
    Map<Integer, DNode> map;
    DNode lowest, highest;

    public Q146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        lowest = null;
        highest = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DNode elem = map.get(key);
        upgradePriority(elem);
        return elem.value;
    }

    public void put(int key, int value) {
        DNode elem;
        if (map.containsKey(key)) {
            elem = map.get(key);
            elem.value = value;
            upgradePriority(elem);
        } else {
            elem = new DNode(key, value);
            map.put(key, elem);
            addPriority(elem);
        }
    }

    private void upgradePriority(DNode p) {
        if (highest == p)
            return;
        else if (lowest == highest && lowest == p)
            return;
        else if (lowest == highest) {
            highest = p;
            lowest.next = highest;
            highest.prev = lowest;
        } else if (lowest == p) {
            lowest = lowest.next;
            lowest.prev = null;
            highest.next = p;
            p.prev = highest;
            p.next = null;
            highest = p;
        } else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
            p.prev = highest;
            highest.next = p;
            p.next = null;
            highest = p;
        }
    }

    private void addPriority(DNode p) {
        if (map.size() > capacity) {
            map.remove(lowest.key);
            if (capacity == 1) {
                lowest = null;
                highest = null;
            } else {
                lowest = lowest.next;
                lowest.prev = null;
            }
        }

        if (lowest == highest && lowest == null) {
            lowest = p;
            highest = p;
            lowest.next = highest;
            lowest.prev = null;
            highest.prev = lowest;
        } else {
            highest.next = p;
            p.prev = highest;
            highest = p;
        }
    }

    public static void main(String[] args) {
        scenario1();
    }

    private static void scenario1() {
        Q146_LRU_Cache cache = new Q146_LRU_Cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    private static void scenario2() {
        Q146_LRU_Cache cache = new Q146_LRU_Cache(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    private static void scenario3() {
        Q146_LRU_Cache cache = new Q146_LRU_Cache(2);
        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private static void scenario4() {
        Q146_LRU_Cache cache = new Q146_LRU_Cache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
