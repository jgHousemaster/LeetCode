package LinkedList;

public class DesignLinkedList_707 {
    class Node {
        // 定义节点，最好叫 ListNode
        public int val;
        public Node next;

        public Node() {
            val = 0;
            next = null;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {

        // 虚拟头节点
        private Node head;
        private int size;

        public MyLinkedList() {
            head = new Node();
            size = 0;
        }

        // index 从零开始
        public int get(int index) {
            if (index >= size || index < 0) {
                return -1;
            } else {
                // 将 cur 设置为第 index 个节点
                Node cur = head;
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
                return cur.val;
            }
        }

        public void addAtHead(int val) {
            // 创建新节点，将 next 设置为 head 的旧 next
            Node newNode = new Node(val, head.next);
            // head 更新 next 为新头节点
            head.next = newNode;
            // 更新链表长度
            size++;
        }

        public void addAtTail(int val) {
            Node newTail = new Node(val, null);
            // 将 cur 设置为第 size 个节点
            Node cur = head;
            for (int i = 0; i < size; i++) {
                cur = cur.next;
            }
            cur.next = newTail;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index <= size && index >= 0) {
                // 将 cur 设置为第 index 个节点
                Node cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                Node newNode = new Node(val, cur.next);
                cur.next = newNode;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < size) {
                // 将 cur 设置为第 index 个节点
                Node cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                size--;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}


