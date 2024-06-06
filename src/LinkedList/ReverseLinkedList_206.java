package LinkedList;

public class ReverseLinkedList_206 {
    // 双指针解法
    public ListNode reverseList(ListNode head) {
        // 初始化双指针
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;

        // 每次循环交换两个节点的位置，并将指针向后移动，直到 cur 指向 null
        while (cur != null) {
            // 更新 cur 的 next 指针
            temp = cur.next;
            cur.next = pre;

            // 双指针向后滑动
            pre = cur;
            cur = temp;
        }
        // 最终 cur 指向 null，pre 指向新的头节点
        return pre;
    }

    // 递归解法
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        // 该函数调换 prev 和 cur 的顺序，并将此过程传递下去（滑动 prev 和 cur），直到 cur 指向 null（递归结束）
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
}
