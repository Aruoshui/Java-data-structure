package LeetCode.简单题;

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
    }

        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(')');
                }else if (ch == '{') {
                    stack.push('}');
                }else if (ch == '[') {
                    stack.push(']');
                }else if (stack.isEmpty() || stack.peek() != ch) {
                    return false;
                }else {
                    stack.pop();
                }

            }
            return stack.isEmpty();
        }

}


/*
class Solution {
    public boolean isValid(String s) {
        while(!s.isEmpty()){
            String t_s = s.replace("()", "").replace("{}", "").replace("[]", "");
            if (t_s.equals(s)) return false; s = t_s;
        }
        return s.isEmpty();
    }
}
 */