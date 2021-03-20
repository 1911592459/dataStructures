package demo.稀疏数组;

//稀疏数组
public class SpraseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子。1：表示黑棋子  2：表示蓝棋子
        int arr [][]=new int[11][11];
        arr[1][2]=1;
        arr[2][3]=2;
        //输出原始的二维数组
        System.out.println("输出原始的二维数组");
        for (int[]rows:arr){
            for (int a:rows){
                System.out.print(" "+a);
            }
            System.out.println();
        }
        //遍历二维数组，得到非0数据个数
        int sum =0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (arr[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组,赋值
        int newarr[][]=new int[sum+1][3];
        newarr[0][0]= arr.length;
        newarr[0][1]= arr[0].length;
        newarr[0][2]=sum;
        //遍历二维数组，将非0的值存放到spraseArr中
        int count =0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if (arr[i][j]!=0){
                    count++;
                    newarr[count][2]=arr[i][j];
                    newarr[count][0]=i;
                    newarr[count][1]=j;
                }
            }
        }
        System.out.println("输出稀疏数组的形式");
        for (int arrs[]:newarr){
            for (int a:arrs){
                System.out.print(" "+a);
            }
            System.out.println();
        }
        //将稀疏数组恢复成原始的二维数组
        int rearr[][]=new int[newarr[0][0]][newarr[0][1]];
        for (int i=1;i<newarr.length;i++){
            rearr[newarr[i][0]][newarr[i][1]]=newarr[i][2];
        }
        System.out.println("输出恢复后的原始数组");
        for (int arr1[]:rearr){
            for (int b:arr1){
                System.out.print(" "+b);
            }
            System.out.println();
        }
    }
}
