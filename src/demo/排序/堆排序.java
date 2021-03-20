package demo.排序;

import java.util.Arrays;

public class 堆排序 {


    //堆排序
    public static int[] heapSort(int arr[]) {
        int temp=0;
        //将数组（二叉树）最大值放到根节点，并变为大顶堆结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            bigHeap(arr, i, arr.length);
        }
        //将最大值和最底部元素交换，然后从剩余元素中继续找最大值（不会破坏大顶堆结构，因为之前已经for循环构建了）
        for (int i = arr.length-1;i >0 ; i--) {
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            bigHeap(arr,0,i);
        }
        return arr;
    }


    /*将一个数组（二叉树），调整成大顶堆
     * i 表示非叶子节点在数组中的索引
     * length 表示对多少个元素进行调整
     *  */
    public static void bigHeap(int arr[], int i, int length) {
        int temp = arr[i];

        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {//保证j永远指向左右子节点中最大的那个
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
                //让i=j往下循环接着找最大值
            } else {
                //这里直接break的原因是规定了i是从最后一个非叶子节点开始的，从右至左，从下至上。所以arr[i]一定是最小的子树
                //这样的话不怕下面的下面还有更大的，因为你就是从最下面开始比较的，大的肯定在前面了。
                break;
            }
            /* 这里i=j继续往下循环和因为从最下面开始所以直接break并不矛盾
             * 因为虽然是从最下面的子树开始循环的，但是for里的第一个if比的永远只是当前子树的左右字节点
             * 这样的话，如果没有for循环，只是把最大值挑了出来拿到最顶端了，但是如果最大值比较靠后，并且偏大值也比较靠后
             * 那样偏大值只是输给了最大值 却没有资格再往上提了。
             * 不进行for循环的话，结果只是拿到了最大值，该二叉树并不是大（小）顶堆结构（每个非叶子节点都>=子节点）
             * 所以要for循环，保持大顶堆结构
             * */
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9, 10, 15, 34, 99, 100};
        int[] sort = heapSort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
