package demo.排序;

import java.util.Arrays;

public class 希尔排序 {

    //交换式，可以理解为分组后的冒泡
    public static int[] shellSort(int[] arr) {
        int t = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {

            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (arr[j] > arr[j + gap]) {
                        t = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = t;
                    }
                }
            }
        }
        return arr;
    }

    //移位式
    public static int[] shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
        System.out.println(Arrays.toString(shellSort(arr)));
        System.out.println(Arrays.toString(shellSort2(arr)));
    }
}
