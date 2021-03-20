package demo.递归;

public class 八皇后 {

    /*
    定义一个一维数组，表示皇后在8x8的棋盘上的位置
    int arr【】={ 1，4，7}
    1表示第0行的皇后在第二个位置
    4表示第1行的皇后在第五个位置
    7表示第2行的皇后在第八个位置

     */

    static int max = 8;//棋盘的长和宽
    static int[] arr = new int[max];//该一维数组类似于稀疏数组，它的下标表示行，它数组存放的值表示第几列，都是从0开始
    //棋盘中的皇后的位置信息就放在此一维数组中
    static int count=0 ;//计数，计有多少种放法


    //打印棋盘
    public static void print(){
        count++;
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }


    public static void check(int n) {//放置第n+1个皇后
        if (n== max) {//如果放置的是最后一个的后一个皇后，说明已经放好了
            //输出
            print();
            return;
        }
        for (int i = 0; i < max; i++) {//每一次都把该皇后从第一列到最后一列依次放一次试试看，这样递归下来就是所有的放法
                                       //因为每次的回溯里都有一个for，即使for中某一次走通了，也不影响它的下一个i。
            arr[n]=i;//先放上去
            if (judge(n)) {//如果该皇后和前面的不冲突，则放置下一个皇后
                check(n+1);
            }
            //如果冲突，则往下一列放，即i+1，所以直接放行，什么也不做

        }

    }

    /*
    n表示第n+1个皇后   比如n=1表示第2个皇后
    i表示在第i+1列，比如i=1表示在第二列
    */
    public static boolean judge(int n) {//检查该皇后是否和前面放置的皇后在同一行同一列同一斜线
        for (int i = 0; i < n; i++) {
            //因为n每次都在递增，所以没必要判断是否在同一行，只需要判断同一列和同一斜线，同一斜线用的是横坐标差的绝对值除以纵坐标差的绝对值，是否相等
            //即是否斜率等于1，来判断的。
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }
}
