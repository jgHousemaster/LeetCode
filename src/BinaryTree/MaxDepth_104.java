package BinaryTree;

import java.util.*;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        // 递归解法
        // 基准
        if (root == null) {
            return 0;
        }
        // 后序遍历求当前节点的高度（左右中）
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public int maxDepth_1(TreeNode root) {
        // 层序遍历
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
