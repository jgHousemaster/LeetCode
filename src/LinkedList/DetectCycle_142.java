package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle_142 {
    public ListNode detectCycle_2pointer(ListNode head) {
        // 算术双指针，时间复杂度是O(n)，空间复杂度是O(1)
        // 创建快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 如果快指针的后面是空，说明无环
        while (fast != null && fast.next != null) {
            // 快指针走两步，慢指针走一步，如果有环则一定相交（两指针相对速度为一步）
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 相遇后，保存相遇位置
                ListNode inter = fast;
                // 新建两个指针，分别从头节点和相遇节点出发，他们的相遇处就是环的起点
                ListNode headPointer = head;
                while (inter != headPointer) {
                    inter = inter.next;
                    headPointer = headPointer.next;
                }
                return inter;
            }
        }
        return null;
    }

    public ListNode detectCycle_hashSet(ListNode head) {
        // 哈希表解法，空间时间复杂度均为O(N)
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public ListNode detectCycle_bruteForce(ListNode head) {
        // 暴力解法，时间复杂度O(n^2)，空间复杂度是O(1)

        // 创立头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        int curSize = 0;
        while (fast.next != null) {
            // 快指针在大循环遍历链表
            fast = fast.next;
            // 记录已经走过几位，小循环扫描前面的节点
            curSize++;
            ListNode slow = dummyHead;
            for(int i = 1; i < curSize; i++) {
                // 快指针每走一步，慢指针遍历快指针之前的所有节点，尝试寻找相同节点。
                if (slow == fast) {
                    return slow;
                }
                slow = slow.next;
            }
        }
        return null;
    }
}
