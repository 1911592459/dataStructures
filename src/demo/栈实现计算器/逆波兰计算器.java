package demo.栈实现计算器;


import java.util.*;

//支持多位数和小括号整数，输入的就是逆波兰式
public class 逆波兰计算器 {
    public static void main(String[] args) {

        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //为了方便，用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int cal = cal(list);

        String s = "10+((2+3)*4)-5";
        List<String> strings = toInfixExpressionList(s);
        System.out.println(strings);
        List<String> change = change(strings);
        System.out.println(change);


    }

    //将得到的中缀表达式List 转换为后缀表达式的List
    public static List<String> change(List<String> list) {
        //本来是初始化俩个栈，但是结果栈中间不出只进，最后才倒序读，所以将结果栈直接改为linkedlist，队列，先进先出。
        List list1 = new LinkedList();//结果栈
        Stack<String> stack = new Stack<>();//运算符栈
        for (String s : list) {
            if (s.matches("\\d+")) {
                list1.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    list1.add(stack.pop());
                }
                stack.pop();//将左括号pop出去
            } else {
                while (stack.size() != 0 && Opertion.getValue(stack.peek()) >= Opertion.getValue(s)) {
                    list1.add(stack.pop());
                }
                stack.push(s);
            }
        }
        while(stack.size()!=0){
            list1.add(stack.pop());
        }
        return list1;
    }


    //将中缀表达式转成相应的List
    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                //如果是字符直接入list中
                list.add(c + "");
                i++;
            } else {//如果是数字，还要考虑是否为多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
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
                } else {
                    throw new RuntimeException("");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

class Opertion {
    private static int ADD = 1;// +
    private static int SUB = 1;// -
    private static int MUL = 2;// *
    private static int DIV = 2;// /

    public static int getValue(String s) {
        int res = 0;
        switch (s) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
        }
        return res;
    }
}