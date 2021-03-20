package demo.查找;

import java.util.Arrays;

public class 斐波那契查找 {

    public static int maxSize =20;
    //创建一个斐波那契数列
    public static int[] fib(){
       int arr[] =new int[maxSize];
       arr[0]=0;
       arr[1]=1;
        for (int i = 2; i < maxSize; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr;
    }

    //非递归的方式
    public static int fabonacciSearch(int arr[],int finalVal){
        int k =0;//k是斐波那契数列的索引，f[k]-1的值代表了arr数组的长度应该被修整为多少
        int f[]=fib();//斐波那契数组
        int mid=0;//分割的位置索引
        int left=0;
        int right=arr.length-1;
        while(arr.length>f[k]-1){//arr数组的长度不一定刚好是f[k]-1，所以要找到arr长度离的最近的f[k]-1的k。
            k++;
        }
        //然后将arr数组长度扩到f[k]-1
        int copy[]=Arrays.copyOf(arr,f[k]-1);
        //将扩后的数组中扩的位置元素值全部赋为原数组的最后一个值
        for (int i = right+1; i < copy.length ; i++) {
            copy[i]=arr[right];
        }
        System.out.println(Arrays.toString(copy));
        while(left<=right){//等于必须有，如果没有，当left=right时候剩一个数没判断。
            mid=left+f[k-1]-1;
            System.out.println(mid);
            if (finalVal<copy[mid]){
                right=mid-1;
                k--;
                //k--是因为f[k]=f[k-1]+f[k-2];
                //f[k-1]=f[k-2]+f[k-3];
                //第一次分成俩个长度后，前一半是f[K-1]，而mid=left+f[k-1]-1;这个公式是根据f[k]=f[k-1]+f[k-2]推出的
                //由f[k-1]=f[k-2]+f[k-3]可以推出的公式是mid=left+f[k-2]-1;
                //但是代码中一直用的是mid=left+f[k-1]-1;所以让k-1，以达到k-2的效果。
            }else if (finalVal>copy[mid]){
                left=mid+1;
                k=k-2;
                //k-2同理。
            }else {//找到的情况下，因为数组是扩容过的且扩容的部分值都是等于原数组最后一个数的
                //所以当left到right的范围只有最后扩容部分时候，mid的值是后面扩容的值的索引，所以需要判断
                if (mid<=right){
                    return mid;
                }else {
                    return right;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] ={1,8,10,89,1000,1234};
        System.out.println(fabonacciSearch(arr, 1234));
        System.out.println(Arrays.toString(fib()));
    }
}
