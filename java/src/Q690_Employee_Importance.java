import java.util.*;

public class Q690_Employee_Importance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        return countSubs(id);
    }

    private int countSubs(int id) {
        Employee e = map.get(id);
        if (e == null)
            return 0;

        map.remove(id);
        int count = e.importance;
        for (int i: e.subordinates) {
            count += countSubs(i);
        }
        return count;
    }

    public static void main(String[] args) {
    }

}
