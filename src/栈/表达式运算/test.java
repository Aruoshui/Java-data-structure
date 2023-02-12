package 栈.表达式运算;
import 栈.链式栈.LinkedStack;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str= in.next();
        System.out.println(PostfixExpression(str));
    }

    public static double PostfixExpression(String str){
        LinkedStack<Integer> operand = new LinkedStack<>(); //操作数栈

        LinkedStack<String>  operator = new LinkedStack<>();//操作符栈
        
        StringBuilder expression = new StringBuilder(str);   //将String转为StringBuilder，方便编辑
        
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                if(operator.isEmpty()) {
                    operator.push(String.valueOf(expression.charAt(i)));
                }
                else if(Priority(String.valueOf(expression.charAt(i))) > Priority(operator.peek())) {   //与操作符栈顶的操作符比较优先级
                    operator.push(String.valueOf(expression.charAt(i)));        //高则入栈
                }
                else {//运算符优先级低，弹出栈顶元素进行运算
                    Integer obj1 = operand.pop();
                    Integer obj2 = operand.pop();
                    Integer res = result(obj2, obj1, operator.pop());

                    operand.push(res);//运算结果入栈
                    operator.push(String.valueOf(expression.charAt(i))); //将之前的低优先级运算符入操作符栈
                }
            }

            else if(expression.charAt(i) == '(') {
                operator.push(String.valueOf(expression.charAt(i)));
            }
            else if(str.charAt(i) == ')') {           //扫描到右括号则循环弹出栈顶符号和操作数栈中的两个数进行运算，结果入栈，知道栈顶符号为左括号为止
                while(!operator.peek().equals("(")) {
                    Integer obj1 = operand.pop();
                    Integer obj2 = operand.pop();
                    Integer res = result(obj2, obj1, operator.pop());
                    operand.push(res);
                }
                operator.pop();
            }


            else if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){   //扫描到数字直接入操作数栈
                int j = i+1;
                StringBuilder MultibitNumber = new StringBuilder(String.valueOf(expression.charAt(i)));   //记录多位数

                int n= MultibitNumber.length();

                while(j<=n && expression.charAt(j) >= '0' && expression.charAt(j) <= '9') {  //防止字符越界
                    MultibitNumber.append(expression.charAt(j));
                    expression.setCharAt(j, ' ');//将拼接过的数字置为空，以免重复入栈
                    j++;

                }
                operand.push(Integer.valueOf(MultibitNumber.toString()));    //转为整型入栈

            }

        }

        if(!operator.isEmpty()) {  //表达式扫描完运算符栈还未空继续计算
            while(!operator.isEmpty()) {
                Integer obj1 = operand.pop();
                Integer obj2 = operand.pop();
                Integer res = result(obj2, obj1, operator.pop());
                operand.push(res);
            }
        }
        return operand.peek();
    }

    public static int Priority(String operator){      //定义操作符的优先级
        if(operator.equals("+") || operator.equals("-"))
            return 1;
        else if(operator.equals("*") || operator.equals("/"))
            return 2;
        else      //()
            return 0;
    }

    public static int result(int obj1, int obj2, String operator) {     //运算
        int result = 0;
        switch(operator) {
            case "+":
                result = obj1 + obj2;
                break;
            case "-":
                result = obj1 - obj2;
                break;
            case "*":
                result = obj1 * obj2;
                break;
            case "/":
                result = obj1 / obj2;
        }
        return result;
    }
}
