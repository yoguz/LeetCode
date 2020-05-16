import common.TreeNode;

public class Q112_Path_Sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && validPath(root, sum);

    }

    private boolean validPath(TreeNode node, int sum) {
        if (node == null)
            return false;

        int remainder = sum - node.val;
        if (remainder != 0 && node.left == null && node.right == null)
            return false;
        else if (remainder == 0 && node.left == null && node.right == null)
            return true;
        else
            return validPath(node.left, remainder) || validPath(node.right, remainder);
    }

    public static void main(String[] args) {
        Q112_Path_Sum obj = new Q112_Path_Sum();
        TreeNode root = TreeNode.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        TreeNode.printTree(root);
        System.out.println(obj.hasPathSum(root, 22));
    }
}
