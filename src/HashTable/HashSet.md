# Hash Set 在 Java 中的实现

Set 继承于 Collection 接口，方法包括添加元素、删除元素和查询元素：add(E e), clear(), remove(Object o), contains(Object o)

Set 实现的额外方法：size(), isEmpty(), iterator()

代码示例：`Set<String> hashSet = new HashSet<>();`

## 分类：

- HashSet：基于哈希表，无序（类似于 C++中的 unordered_set）
- LinkedHashSet：基于哈希表和链表，保留元素插入顺序 
- TreeSet：基于红黑树，自动排序（类似于 C++ 中的 set）

## 遍历 Set

- 增强型 for 循环：
```java
for (Type element : set) {
    // 处理元素 element
        }
```
- Lambda 表达式
```java
set.forEach(element -> /* 处理元素 element*/)
```
- 转换为数组
```java
Object[] array = set.toArray();
```

## 将数组转化为 HashSet

- Collections.addAll：
```java
Set<Type> hashSet = new HashSet<>();
Collections.addAll(hashSet, array);
```
- Arrays.asList:
```java
Set<Type> hashSet = new HashSet<>(Arrays.asList(array));
```
- for 循环:
```java
for (Type element : array) {
    set.add(element);
        }
```