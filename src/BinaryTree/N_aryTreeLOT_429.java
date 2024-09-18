package BinaryTree;

import java.util.*;

public class N_aryTreeLOT_429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size > 0) {
                Node curNode = queue.poll();
                if (!curNode.children.isEmpty()) {
                    for (Node child : curNode.children) {
                        queue.offer(child);
                    }
                }
                list.add(curNode.val);
                size--;
            }

            result.add(list);
        }

        return result;
    }
}
