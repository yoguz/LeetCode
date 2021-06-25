import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q684_Redundant_Connection {

    public int[] findRedundantConnectionWorse(int[][] edges) {
        Map<Integer, Set<Integer>> groupToNodesMap = new HashMap<>();
        Map<Integer, Integer> nodeToGroupMap = new HashMap<>();

        for (int[] edge: edges) {
            if (nodeToGroupMap.getOrDefault(edge[0], -1) == nodeToGroupMap.getOrDefault(edge[1], -2))
                return edge;

            for (int i = 0; i < 2; ++i)
                if (nodeToGroupMap.get(edge[i]) == null) {
                    nodeToGroupMap.put(edge[i], edge[i]);
                    groupToNodesMap.put(edge[i], new HashSet<>());
                    groupToNodesMap.get(edge[i]).add(edge[i]);
                }

            int newGroup = Math.min(nodeToGroupMap.get(edge[0]), nodeToGroupMap.get(edge[1]));
            int oldGroup = Math.max(nodeToGroupMap.get(edge[0]), nodeToGroupMap.get(edge[1]));

            Set<Integer> oldGroupSet = groupToNodesMap.get(oldGroup);
            Set<Integer> newGroupSet = groupToNodesMap.get(newGroup);
            for (Integer i: oldGroupSet) {
                nodeToGroupMap.replace(i, newGroup);
                newGroupSet.add(i);
            }

            groupToNodesMap.remove(oldGroup);
        }

        return new int[]{0,0};
    }


    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; ++i)
            parent[i] = i;

        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t))
                return edge;

            else
                parent[find(parent, f)] = find(parent, t);
        }

        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f != parent[f])
            parent[f] = find(parent, parent[f]);

        return f;
    }

    public static void main(String[] args) {
        Q684_Redundant_Connection obj = new Q684_Redundant_Connection();
        int[] res = obj.findRedundantConnection(new int[][]{
                {1,5},{3,4},{3,5},{4,5},{2,4}
        });
        System.out.println(res[0] + "," + res[1]);
    }

}
