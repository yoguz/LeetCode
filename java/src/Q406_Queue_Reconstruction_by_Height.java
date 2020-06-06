import java.util.*;

public class Q406_Queue_Reconstruction_by_Height {


    public int[][] reconstructQueue(int[][] people) {
        if (people.length < 2)
            return people;

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for (int[] i: people) {
            if (!map.containsKey(i[0])) {
                map.put(i[0], new ArrayList<>());
                keys.add(i[0]);
            }
            map.get(i[0]).add(i[1]);
            i[1] = -1;
        }

        map.forEach((k, v) -> Collections.sort(v));
        Collections.sort(keys);
        int count, i;
        for (Integer key: keys) {
            count = 0; i = 0;
            for (Integer val: map.get(key)) {
                while(true) {
                    if (count == val && people[i][1] == -1) {
                        people[i][0] = key;
                        people[i][1] = val;
                        break;
                    } else if (people[i][1] == -1 || people[i][0] == key)
                        count++;
                    i++;
                }
            }
        }

        return people;
    }

    public static void main(String[] args) {
        Q406_Queue_Reconstruction_by_Height obj = new Q406_Queue_Reconstruction_by_Height();
        int[][] res = obj.reconstructQueue(new int[][] {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        });
        for (int[] i: res)
            System.out.print("[" + i[0] + "," + i[1] + "], ");
    }
}
