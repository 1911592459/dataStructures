package demo.栈实现计算器;



//小括号小数点负数，减号在前都还未实现
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2";
        //String expression = "1*2-2/1+1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        boolean flag = true;
        int a = 0;
        int i = 1;
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()) {//不为空的处理,比较优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {//如果该运算符优先级低于栈顶的，就在当前栈取俩个数字和一个符号进行运算，再将结果放进数字栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把结果入数字栈
                        numStack.push(res);
                        //把当前的符号入符号栈
                        operStack.push(ch);
                    } else {//如果该运算符优先级大于栈顶的，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {//当前符号栈为空
                    operStack.push(ch);
                }
            } else {//如果是数字，需要多看一位，如果下一位依然是数字就继续往下看，防止多位数的出现。
                /*a=index;
                while(flag){
                    if (a+1==expression.length()){
                        break;
                    }
                    if (operStack.isOper(expression.substring(a+1,a+2).charAt(0))){
                        numStack.push(ch - 48);//char对应的int：asc码值
                        flag=false;
                    }else {
                        i++;
                        ch=expression.substring(index,index+i).charAt(0);
                        a++;
                    }
                }
                flag=true;*/
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
                /*numStack.push(ch - 48);//char对应的int：asc码值*/
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (true) {//将栈中剩下的数字和符号直接从上到下运算。最后将res放进数字栈中
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        numStack.list();
    }
}

class ArrayStack2 {
    int maxSize;//栈的大小
    int[] stack;//数组模拟栈
    int top = -1;//栈顶，初始值-1

    //自己定义运算符的优先级,数字越大优先级越高.
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //读当前栈顶的值，是读，不是取
    public int peek() {
        return stack[top];
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;//存放数据结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 + num2;
                break;
            default:
                break;
        }
        return res;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    public ArrayStack2() {
    }

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public ArrayStack2(int maxSize, int[] stack, int top) {
        this.maxSize = maxSize;
        this.stack = stack;
        this.top = top;
    }
}