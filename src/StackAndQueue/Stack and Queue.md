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

- 既可以实现栈，又可以实现队列
- 创建：`Deque<Integer> deque = new ArrayDeque<>();` （也可以用 LinkedList，不过开销更大）
- `deque.addFirst(1);` 在队首增加元素（相当于`deque.push(1)`）
- `deque.addLast(1);` 在队尾增加元素
- `int i = deque.removeFirst();` 弹出队首元素（相当于`deque.pop()`）
- `int i = deque.removeLast();` 弹出队尾元素
- `int i = deque.peekFirst();` 查看队首元素（相应的，也可以用 peekLast）