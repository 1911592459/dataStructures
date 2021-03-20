package demo.数组模拟栈;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack =new ArrayStack(4);

    }
}

class ArrayStack {
    int maxSize;//栈的大小
    int[] stack;//数组模拟栈
    int top = -1;//栈顶，初始值-1


    //入栈
    public void push(int value){
        if (isFull()){
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈
    public Integer pop(){
        if (isEmpty()){
            return null;
        }
        int value =stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if (isEmpty()){
            return;
        }
        for (int i=top;i>=0;i--){
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

    public ArrayStack() {
    }

    public ArrayStack(int maxSize) {
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

    public ArrayStack(int maxSize, int[] stack, int top) {
        this.maxSize = maxSize;
        this.stack = stack;
        this.top = top;
    }
}