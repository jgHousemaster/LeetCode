package BinaryTree;

import java.util.*;

public class MinDepth_111 {
    public int minDepth_01(TreeNode root) {
        // 递归解法
        // 基准
        if (root == null) {
            return 0;
        }
        // 后序遍历求高度（左右中）
        // 只有一边为空不是叶子节点，取有子节点的子树的值
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            // 两边都空或都有值
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
    public int minDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            while (size > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return result;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                size--;
            }
        }
        return result;
    }
}
