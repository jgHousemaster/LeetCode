# HashMap 在 Java 中的实现

## Java 中的 Map

- HashMap
  - 基于哈希实现，不保证顺序
- TreeMap
  - 按照自然顺序或比较器排序
- LinkedHashMap
  - 维护插入顺序

## 创建

```java
Map<String, Integer> hashMap = new HashMap<>();
```

## 方法

put(K key, V value)：插入元素，可覆盖

get(Object key)：返回对应 key 的 value。不存在则返回 null。

getOrDefault(Object key, V defaultValue)： 返回对应 value 或者默认值

remove(Object key)：移除元素

containsKey(Object key)：检查是否有 key

containsValue(Object value)：检查是否有 value

isEmpty()：是否为空

size()：键值对个数

keySet()：返回包括所有 key 的集合

values()：同上，所有 value

entrySet()：返回所有键值对