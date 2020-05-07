import common.TreeNode;

public class Q993_Cousins_in_Binary_Tree {

    class Pair {
        int parent;
        int depth;
        Pair(int p, int d) {
            this.parent = p;
            this.depth = d;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y)
            return false;


        Pair px = findParent(root, x, 0);
        Pair py = findParent(root, y, 0);

        if (px != null && py != null && px.parent != py.parent && px.depth == py.depth)
            return true;
        return false;
    }

    private Pair findParent(TreeNode node, int i, int d) {
        if (node == null)
            return null;

        if (node.left != null && node.left.val == i)
            return new Pair(node.val, d+1);
        else if(node.right != null && node.right.val == i)
            return new Pair(node.val, d+1);
        else {
            Pair l = findParent(node.left, i, d+1);
            if (l == null)
                return findParent(node.right, i, d+1);
            else
                return l;
        }
    }

    public static void main(String[] args) {
        Q993_Cousins_in_Binary_Tree obj = new Q993_Cousins_in_Binary_Tree();
        Integer[] arr = new Integer[]{1,2,3,null,4,null,5};
        TreeNode root = TreeNode.createTree(arr);
        System.out.println(obj.isCousins(root, 5, 4));
        TreeNode.printTree(root);
    }
}
