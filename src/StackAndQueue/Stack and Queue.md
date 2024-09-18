# Stack and Queue

## Stack

- 创建：`Stack<Integer> stack = new Stack<>();`
- 写入：`stack.push(13);`
- 弹出：`result = stack.pop();`
- 是否为空：`stack.isEmpty();`

## Queue

- 创建：`Queue<Integer> queue = new LinkedList<>();`
- 写入：`queue.offer(10);`
- 弹出队首：`result = queue.poll();`

## Deque

- 既可以实现栈，又可以实现队列，开销更小
- 可以直接沿用 Stack 和 Queue 的方法（push, pop, offer, poll）
- 创建：`Deque<Integer> deque = new ArrayDeque<>();` （也可以用 LinkedList，不过开销更大）
- `deque.addFirst(1);` 在队首增加元素
- `deque.addLast(1);` 在队尾增加元素
- `int i = deque.removeFirst();` 弹出队首元素（相当于`deque.pop()`）
- `int i = deque.removeLast();` 弹出队尾元素
- `int i = deque.peekFirst();` 查看队首元素（相应的，也可以用 peekLast）

## PriorityQueue

- 创建：`PriorityQueue<Integer> pq = new PriorityQueue<>();`, 默认是最小堆, 带比较器的构造函数可以实现最大堆：`PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());`
- 插入：`pq.offer(10);` 或者 `pq.add(10);`
- 弹出：`int i = pq.poll();`
- 查看堆顶：`int i = pq.peek();`
- 其他方法：`pq.size()`, `pq.isEmpty()`, `pq.contains(10)`， `pq.remove(10)`， `pq.clear()`

## 如何选择实现方法

- 只在一端插入的，选择 ArrayList 和 ArrayDeque （大多数情况）
- 需要在中间插入的，选择 LinkedList
- Stack 和 Queue 都可以用 ArrayDeque 代替