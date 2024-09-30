package BinaryTree;

import java.util.*;

public class BinaryTreePath_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getPath(root, path, result);
        return result;
    }

    void getPath(TreeNode root, List<Integer> path, List<String> result) {
        // 前序遍历，但要先加上本节点再处理触底反弹条件
        path.add(root.val);
        if (root.left == null && root.right == null) {
            // 该 path 已经完整，打印结果放进 result
            String curPath = "";
            for (int i = 0; i < path.size(); i++) {
                curPath += path.get(i);
                if (i != path.size() - 1) {
                    // 这还不是最后一个元素
                    curPath += "->";
                }
            }
            result.add(curPath);
            return;
        }
        if (root.left != null) {
            getPath(root.left, path, result);
            // 回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            getPath(root.right, path, result);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
