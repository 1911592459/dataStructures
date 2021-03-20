package demo.排序;

import java.util.Arrays;

public class 冒泡排序 {
    public static int[] bubbleSort(int[] arr) {
        int t = 0;
        boolean flag =false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            //如果提前排序好 就跳出
            if (!flag){
                break;
            }else {
                flag=false;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 2};
        int[] sort = bubbleSort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
