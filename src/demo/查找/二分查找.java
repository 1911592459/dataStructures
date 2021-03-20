package demo.查找;

import java.util.ArrayList;
import java.util.List;

public class 二分查找 {

    public static int binarySearch(int arr[], int left, int right, int finalVal) {
        if (left > right) {//没找到
            return -1;
        }
        int mid = (left + right) / 2;
        if (finalVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, finalVal);
        } else if (finalVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, finalVal);
        } else {
            return mid;
        }
    }

    //升级版，如果有相同的数，可以找到全部的索引
    public static List binarySearch2(int arr[], int left, int right, int finalVal) {
        if (left > right) {//没找到
            return null;
        }
        int mid = (left + right) / 2;
        if (finalVal > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, finalVal);
        } else if (finalVal < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, finalVal);
        } else {
            List<Integer> arrayList = new ArrayList<>();
            int temp = mid - 1;
            int temp2 = mid + 1;
            while (temp > 0 && arr[temp] == finalVal) {
                arrayList.add(temp);
                temp--;
            }
            arrayList.add(mid);
            while (temp2 <= arr.length - 1 && arr[temp2] == finalVal) {
                arrayList.add(temp2);
                temp2++;
            }
            return arrayList;
        }
    }

    public static void main(String[] args) {
        /*int arr [] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
        }*/
        int arr[] = new int[]{-1000, -10, -5, -1};
        //binarySearch2(arr,0,2,1000);
        //  binarySearch2(arr,0,3,-1000);
        System.out.println(binarySearch2(arr, 0, 3, -1));
    }
}

