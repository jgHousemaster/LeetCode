package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 建立结果数组
        List<Integer> result = new LinkedList<>();
        // 调用递归函数
        traversal(root, result);

        return result;
    }

    public void traversal(TreeNode cur, List<Integer> result) {
        // 最底层递归
        if (cur == null)
            return;
        // 超级操作，前序为中左右，中序为左中右，后序为左右中
        result.add(cur.val);
        traversal(cur.left, result);
        traversal(cur.right, result);
    }

}
