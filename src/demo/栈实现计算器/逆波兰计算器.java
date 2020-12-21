package demo.栈实现计算器;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//支持多位数和小括号整数，输入的就是逆波兰式
public class 逆波兰计算器 {
    public static void main(String[] args) {

        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //为了方便，用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int cal = cal(list);
        System.out.println(cal);

    }

    //将一个逆波兰表达式的运算符和数字依次放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int cal(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {//正则表达式，匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出俩个数 进行运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
