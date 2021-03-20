package demo.排序;

import java.util.Arrays;

public class 选择排序 {

    public static int[] selectSort(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex =i;
            int min =arr[i];
            for (int j=i+1;j< arr.length;j++){
                if (arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr =new int[]{1,-1,5,10};
        System.out.println(Arrays.toString(selectSort(arr)));
    }
}
