package BinaryTree;

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return !(getHeight(root) == -1);
    }

    int getHeight(TreeNode root) {
        // 求高度的同时判断是否平衡，一个递归做两件事
        if (root == null) {
            return 0;
        }
        // 后序遍历
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 该层不平衡，返回-1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 该层平衡，返回高度
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
