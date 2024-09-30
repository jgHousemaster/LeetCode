# Java 中的 List

## 种类

- ArrayList
  - 基于数组实现，支持随机访问
- LinkedList
  - 基于双向链表实现，支持快速插入和删除
  - 除非需要频繁随机访问，否则优先使用
- Stack
  - 继承自 Vector，线程安全
  - 通常用 Deque 代替
- Vector
  - 线程安全，性能较差

## 创建

    ```java
    List<Integer> list = new ArrayList<>();
    ```

## 方法

- `add(E e)`：添加元素
- `addAll(Collection<? extends E> c)`：添加集合
- `clear()`：清空
- `contains(Object o)`：是否包含元素
- `get(int index)`：获取元素
- `indexOf(Object o)`：元素第一次出现的位置
- `isEmpty()`：是否为空
- `remove(int index)`：移除元素
- `size()`：元素个数
- `toArray()`：转为数组
- `toArray(T[] a)`：转为数组