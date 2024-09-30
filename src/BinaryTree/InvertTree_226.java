package BinaryTree;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        // 触底反弹情况
        if (root == null) {
            return root;
        }
        // 前序遍历（中左右）
        // 处理中（根节点）
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 处理前后
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
