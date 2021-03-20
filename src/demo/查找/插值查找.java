package demo.查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 插值查找 {
    //和二分一样，要求传入的数组是有序的
    public static int insertValSearch(int arr[], int left, int right, int finalVal) {
        if (left > right) {//没找到
            return -1;
        }
        int mid;
        if (arr.length == 1) {//排除分母为0报错
            mid = 0;
        } else {
            mid = left + (right - left) * (finalVal - arr[left]) / (arr[right] - arr[left]);
        }
        if (finalVal > arr[mid]) {
            return insertValSearch(arr, mid + 1, right, finalVal);
        } else if (finalVal < mid) {
            return insertValSearch(arr, left, mid - 1, finalVal);
        } else {
            return mid;
        }
    }

    //升级版，支持查相同数
    public static List insertValSearch2(int arr[], int left, int right, int finalVal) {
        if (left > right) {//没找到
            return null;
        }
        int mid;
        if (arr.length == 1) {//排除分母为0报错
            mid = 0;
        } else {
            mid = left + (right - left) * (finalVal - arr[left]) / (arr[right] - arr[left]);
        }
        if (finalVal > arr[mid]) {
            return insertValSearch2(arr, mid + 1, right, finalVal);
        } else if (finalVal < mid) {
            return insertValSearch2(arr, left, mid - 1, finalVal);
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
//        int arr[] = new int[100];
//        for (int i = 0; i < 100; i++) {
//            arr[i] = i + 1;
//        }
//        arr[1] = 1;
        int arr[] = new int[]{1,300,500,10000};
        //System.out.println(insertValSearch(arr, 0, 1, 1));
        System.out.println(insertValSearch2(arr, 0, 3, 500));
    }
}
