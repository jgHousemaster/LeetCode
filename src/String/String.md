# String 在 Java 中的应用

## 新建字符数组

char[] sArray = s.toCharArray(); // 字符串转数组

String s = new String(sArray); // 数组转字符串

// new String(sArray, 1, 6);

## String 的函数

str.charAt(0); // 取出字符串某一位的字符（从 0 开始）

str.substring(3, 7); // 取出子串（不写后一个参数就取到末尾）

str.indexOf("abc"); // 返回字符串中第一次出现某子串的位置

str.lastIndexOf("abc"); // 最后一次出现

str.contains("abc"); // 是否包含

str.equals(str2); // 字符串是否相等
## 操作字符串内部：StringBuilder

- 创建

StringBuilder sb = new StringBuilder(); // 括号内可以置空，可以放初始内容，也可以放初始长度。默认长度为 16

- 方法

```java
sb.append("aaa"); // 在结尾追加
sb.insert(5, "aaa"); // 指定位置插入
sb.replace(7, 12, "aaa"); // 替换
sb.delete(5, 7); // 删除

sb.setChatAt(1, "a"); 
sb.charAt(1);
        
sb.reverse; // 翻转
sb.length(); // 长度
sb.capacity(); // 容量

String s = sb.toString(); // 转换为 String
```