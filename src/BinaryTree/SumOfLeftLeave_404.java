package BinaryTree;

public class SumOfLeftLeave_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        // 后序遍历
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);

        int sum = leftSum + rightSum;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum;
    }
}
