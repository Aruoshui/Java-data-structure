package 高级Java程序开发.第一次作业.字符串重复;

//给定一个字符串，按照字母表的顺序输出每个字母及出现的次数

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Letter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Letter_number(str);

    }

    public static void Letter_number(String str) {
        Map<Character, Integer> map = new TreeMap<>();
        str = str.toLowerCase();// 将字符串转为小写，方便统计字母出现次数

        // 遍历字符串中的每个字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 如果该字符是一个字母，则统计该字母出现的次数

            if (Character.isLetter(c)) {
                // 如果该字母已经存在于map中，则取出其计数器并加1，否则将计数器设为1
                if (map.containsKey(c)) {
                    int count = map.get(c) + 1;
                    map.put(c, count);
                } else {
                    map.put(c, 1);
                }
            }

        }

        // 遍历map中的键值对，输出每个字母及其出现次数
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {   //Map集合通过entrySet()方法转换成的这个set集合，set集合中元素的类型是Map.Entry<Character, Integer>
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}



