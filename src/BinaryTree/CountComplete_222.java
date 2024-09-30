package BinaryTree;

public class CountComplete_222 {
    public int countNodes(TreeNode root) {
        // 节点为空
        if (root == null) {
            return 0;
        }
        // 节点不为空时，通过两侧 DFS 判断此节点是否为满二叉树的顶点
        int leftDepth = 1;
        int rightDepth = 1;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        while (leftNode != null) {
            leftNode = leftNode.left;
            leftDepth++;
        }
        while (rightNode != null) {
            rightNode = rightNode.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            // 满二叉树，整棵树的节点数为 2^n - 1
            return (int) Math.pow(2, leftDepth) - 1;
        }
        // 非满二叉树，正常进行后序遍历
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
