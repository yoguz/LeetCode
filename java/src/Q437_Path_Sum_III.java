import common.TreeNode;

public class Q437_Path_Sum_III {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return validPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int validPath(TreeNode start, int sum) {
        if (start == null)
            return 0;

        int remainder = sum - start.val;
        if (remainder == 0)
            return 1 + validPath(start.left, 0) + validPath(start.right, 0);
        else
            return validPath(start.left, remainder) + validPath(start.right, remainder);
    }

    public static void main(String[] args) {
        Q437_Path_Sum_III obj = new Q437_Path_Sum_III();
        TreeNode root = TreeNode.createTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(obj.pathSum(root, 8));
    }
}
