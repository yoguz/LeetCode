import common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Q449_Serialize_and_Deserialize_BST {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(nodes, new AtomicInteger(0));
    }

    public TreeNode deserializeHelper(String[] nodes, AtomicInteger idx) {
        if ( nodes.length <= idx.get() || nodes[idx.get()].length() == 0) {
            idx.set(idx.get()+1);
            return null;
        }

        int val = Integer.parseInt(nodes[idx.get()]);
        TreeNode node = new TreeNode(val);
        idx.set(idx.get()+1);

        node.left = deserializeHelper(nodes, idx);
        node.right = deserializeHelper(nodes, idx);

        return node;
    }

    public static void main(String[] args) {
        Q449_Serialize_and_Deserialize_BST obj = new Q449_Serialize_and_Deserialize_BST();
        TreeNode n8 = new TreeNode(8);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n10 = new TreeNode(10);
        TreeNode n14 = new TreeNode(14);
        TreeNode n13 = new TreeNode(13);
        n8.left = n3; n8.right = n10;
        n3.left = n1; n3.right = n6;
        n6.left = n4; n6.right = n7;
        n10.right = n14;
        n14.left = n13;

        TreeNode.printTree(n8);
        String seri = obj.serialize(n8);
        System.out.println(seri);
        TreeNode des = obj.deserialize(seri);
        TreeNode.printTree(des);
    }
}
