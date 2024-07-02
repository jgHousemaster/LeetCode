package LinkedList;

public class IntersectionOfLL_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 暴力解法
        ListNode curA = headA;

        while (curA != null) {
            ListNode curB = headB;
            while (curB != null) {
                if (curB == curA) {
                    return curA;
                }
                curB = curB.next;
            }
            curA = curA.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 计算两个链表的长度差值
        int difference = getSize(headA) - getSize(headB);
        // 创建指针并将两个链表结尾对齐
        ListNode curA = headA;
        ListNode curB = headB;
        while (difference > 0 && curA != null) {
            curA = curA.next;
            difference--;
        }
        while (difference < 0 && curB != null) {
            curB = curB.next;
            difference++;
        }
        // 两个指针同步前进
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public int getSize(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
}
