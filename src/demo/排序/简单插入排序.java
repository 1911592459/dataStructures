package demo.排序;

import java.util.Arrays;

public class 简单插入排序 {

    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];//每次从无序表中取一个元素
            int insertIndex = i - 1;//相当于有序表中目前排到第几个数的索引了。从0开始
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//将每次for循环取出的一个无序表中的元素依次与有序表中的比较
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        简单插入排序 q =new 简单插入排序();
        System.out.println(Arrays.toString(q.insertSort(arr)));
    }
}
