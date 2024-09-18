package BinaryTree;

import java.util.*;

public class LevelOrderTraversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 建立队列和结果数组，初始化
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            queue.offer(root);
        }

        // 遍历二叉树
        while (!queue.isEmpty()) {
            // 记录本层节点个数
            int size = queue.size();
            // 保存本层节点
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                list.add(curNode.val);
                size--;
            }
            result.add(list);
        }

        Collections.reverse(result);
        return result;
    }
}
