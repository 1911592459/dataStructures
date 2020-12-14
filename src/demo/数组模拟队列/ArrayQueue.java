package demo.数组模拟队列;


//数组模拟队列
public class ArrayQueue {
    public static void main(String[] args) {
        Queue queue =new Queue(3);
        queue.addQueue(10);
        queue.addQueue(20);
        queue.addQueue(30);
        System.out.println(queue.getFront());
        System.out.println(queue.getQueue());
        System.out.println(queue.getFront());
        System.out.println(queue.getQueue());
        System.out.println(queue.getFront());
        System.out.println(queue.getQueue());
        System.out.println(queue.getFront());
        System.out.println(queue.getQueue());
    }
}
class Queue{
        private int arr[] ;
    private int front;//数组头
    private int rear;//数组尾
    private int maxSize;

    public Queue(int maxSize) {
        arr=new int[maxSize];
        this.maxSize=maxSize;
        front=-1;
        rear=-1;
    }
//判断是否为空

    public boolean isEmpty(){
        return rear==front;
    }
    //判断是否满

    public boolean isFull(){
        return rear==maxSize-1;
    }
    //取数据

    public int getQueue(){

            if (isEmpty()){
                return 0;
            }else {
                front++;
                return  arr[front];
            }

    }

    //取头数据
    public int head(){
        return arr[front+1];
    }
    //添加数据
    public void addQueue(int data){
        if(isFull()){
            return;
        }else {
            rear++;
            arr[rear]=data;
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