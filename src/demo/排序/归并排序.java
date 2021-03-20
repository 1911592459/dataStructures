package demo.排序;

import java.util.Arrays;

public class 归并排序 {


    //分+合
    public static int[] mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);//左递归不断分解
            mergeSort(arr, mid + 1, right, temp);//右递归不断分解
            merge(arr, left, mid, right, temp);//合并
        }
        return arr;
    }


    //合并
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左边有序序列的索引
        int j = mid + 1;//右边有序序列的索引
        int t = 0;//临时数组的索引
        //将俩个有序序列合并为一个有序序列,存放到temp数组中
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i = i + 1;
                t = t + 1;
            } else {
                temp[t] = arr[j];
                j = j + 1;
                t = t + 1;
            }
        }
        //当有一边没数据的时候，让另一边剩下的数直接进temp
        while (i <= mid) {
            temp[t] = arr[i];
            i = i + 1;
            t = t + 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j = j + 1;
            t = t + 1;
        }
        //然后将temp拷贝给arr
        t = 0;//temp的索引
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t = t + 1;
            templeft = templeft + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,6,5,7,-1,4,2};
        int[] temp = new int[arr.length];
        //mergeSort(arr,0, arr.length-1, temp);
        System.out.println(Arrays.toString(mergeSort(arr,0, arr.length-1, temp)));
    }
}
