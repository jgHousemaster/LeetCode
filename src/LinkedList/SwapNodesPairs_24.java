package LinkedList;

public class SwapNodesPairs_24 {
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while(cur.next != null && cur.next.next != null) {
            // 断链前先存储
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;
            // 更新三次链接
            cur.next = temp1.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            // 移动指针至下一对节点之前一位
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
