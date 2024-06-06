package LinkedList;

public class RemoveElement_203 {
    public static ListNode removeElements(ListNode head, int val) {
        // 标准解法，先处理头节点，再处理后续节点

        // 处理头节点为 target 的情况
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 头节点确定不是 target，处理后续元素
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        // 使用虚拟头节点，统一操作
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 先不往前推进，直到 cur 的 next 不是 target
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);

        node.next = node2;
        node2.next = node3;

        ListNode newHead = removeElements(node, 1);
        System.out.println(newHead.next.val);

    }
}
