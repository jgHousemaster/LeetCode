package LinkedList;

public class RemoveNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 先数链表长度，再找到目标节点
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        int size = 0;
        while(cur.next != null){
            size++;
            cur = cur.next;
        }
        cur = dummyHead;
        for(int i = 0; i < size - n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(0, head);
        // 快慢指针初始化
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 快指针走 n + 1 步
        n = n + 1;
        while(n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        // 两指针同步前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除目标节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
