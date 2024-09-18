package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        // 遍历二叉树
        while (!queue.isEmpty()) {
            // 整体遍历
            // 本层节点数
            int size = queue.size();
            // 保存本层的数据
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                // 层内遍历
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                // size 用来提醒本层与下层节点的分界线
                size--;
            }
            // 将本层放入结果数组
            result.add(list);
        }

        return result;
    }

}
