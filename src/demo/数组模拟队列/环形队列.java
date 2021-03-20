package demo.数组模拟队列;

public class 环形队列 {
    public static void main(String[] args) {
        Queue1 queue1 =new Queue1(3);
        queue1.addQueue(10);
        System.out.println(queue1.getRear());
        queue1.addQueue(100);
        System.out.println(queue1.getRear());
        queue1.showQueue();
    }
}

class Queue1 {
    private int arr[];
    private int front;//数组头
    private int rear;//数组尾
    private int maxSize;

    public Queue1(int maxSize) {
        arr = new int[maxSize];
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
    }
    //求出有效数据的个数
    public int size(){
       return (rear+maxSize-front)%maxSize;
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            return;
        }else {
            for (int i=front;i<front+size();i++){
                System.out.println(arr[i%maxSize]);
            }
        }
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //判断是否满
    public boolean isFull() {

        return (rear + 1) % maxSize == front;
    }

    //取数据,出队列
    public int getQueue() {

        if (isEmpty()) {
            return 0;
        } else {
            int value = arr[front];
            front=(front+1)%maxSize;
            return value;
        }

    }

    //取头数据
    public int head() {
        return arr[front];
    }

    //添加数据
    public void addQueue(int data) {
        if (isFull()) {
            return;
        } else {
            arr[rear] = data;
            rear = (rear + 1) % maxSize;
        }
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


}