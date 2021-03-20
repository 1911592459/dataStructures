package demo.树;



//对数组实现顺序存储二叉树，并进行遍历,只考虑完全二叉树
public class 顺序存储二叉树 {

    //index表示从第几个数开始遍历
    //前序遍历数组
    public static void preOrder(int []arr,int index){
        if (arr==null||arr.length==0){
            return;
        }
        System.out.println(arr[index]);
        if ((index*2+1)<arr.length){
            preOrder(arr,2*index+1);
        }
        if ((index*2+2)<arr.length){
            preOrder(arr,2*index+2);
        }


    }

    public static void main(String[] args) {
        int arr []={1,2,3,4,5,6,7};
        preOrder(arr,0);
    }
}