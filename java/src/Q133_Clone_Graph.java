import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q133_Clone_Graph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> copyMap = new HashMap<>();
        return dfs(node, copyMap);
    }

    private Node dfs(Node n, Map<Node, Node> copyMap) {
        if (n == null)
            return null;

        if (copyMap.containsKey(n))
            return copyMap.get(n);

        Node newNode = new Node(n.val);
        copyMap.put(n, newNode);

        for (Node neighbor: n.neighbors) {
            newNode.neighbors.add(dfs(neighbor, copyMap));
        }

        return newNode;
    }

    public static void main(String[] args) {

    }
}
