package demo.排序;

import java.util.Arrays;
//基数排序不适用于数组中有负数的，因为负数的话 桶这个数组的下标就是负的了.非要用也是可以的.
public class 基数排序 {

    public static int[] radixSort(int arr[]){
        //定义一个二维数组，表示十个桶，0-9,每个桶都是一个一维数组
        int bucket[][] =new int[10][arr.length];
        //定义一个一维数组，记录每个桶（0-9）里的数的个数
        int bucketElementsCounts[] =new int[10];
        //找一下数组中最大数
        int max =arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        //找一下数组中最大数的位数
        int maxlength =(max+"").length();
        int b=1;
        for (int a =0;a<maxlength;a++){

            for (int i = 0; i < arr.length ; i++) {
                int num =arr[i]/b%10;//取个位数，十位数，百位数....
                bucket[num][bucketElementsCounts[num]]=arr[i];
                bucketElementsCounts[num]++;
            }
            //将桶里的数依次取出到arr里
            int index =0;
            for (int j = 0; j < bucketElementsCounts.length; j++) {
                //如果该桶里有数，则取出
                if (bucketElementsCounts[j]!=0){
                    for (int l = 0; l <bucketElementsCounts[j] ; l++) {
                        arr[index]=bucket[j][l];
                        index++;
                    }
                }
                //第a轮处理完后需要将记录每个桶中数的个数清空
                bucketElementsCounts[j]=0;
            }
            b=b*10;
        }

        return arr;

    }

    public static void main(String[] args) {
        int arr[]={53,3,542,748,14,214};
        System.out.println(Arrays.toString(radixSort(arr)));
    }
}
