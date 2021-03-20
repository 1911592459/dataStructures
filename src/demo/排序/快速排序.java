package demo.排序;

import java.util.Arrays;

public class 快速排序 {

    public static int[] quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int medianVal = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < medianVal) {
                l = l + 1;
            }
            while (arr[r] > medianVal) {
                r = r - 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == medianVal) {
                r = r - 1;
            }
            if (arr[r] == medianVal) {
                l = l + 1;
            }
        }
        if(l==r){
            l=l+1;
            r=r-1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,-1,-5,2,13};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }
}
