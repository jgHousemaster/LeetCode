package BinaryTree;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return check(root.left, root.right);
        }
    }

    public boolean check(TreeNode left, TreeNode right) {
        // 触底反弹条件
        if (left == null && right == null) {
            // 两边都空，对称
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            // 排除两边都空情况后，仍有一空则不对称；两边值不同也不对称
            return false;
        }
        // 后序遍历
        boolean outside = check(left.left, right.right);
        boolean inside = check(left.right, right.left);
        return outside && inside;
    }
}
