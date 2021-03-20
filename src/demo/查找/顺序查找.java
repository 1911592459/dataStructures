package demo.查找;

public class 顺序查找 {
    public static void main(String[] args) {
        int arr[]={1,9,11,-1,34,89};

    }
    public static int seqSearch(int []arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;//返回的是位置
            }
        }
        return -1;
    }
}
