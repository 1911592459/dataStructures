package demo.递归;

public class 迷宫 {

    /*
    使用递归回溯来给小球找路
    map表示地图
    i,j表示从地图哪个位置开始出发（1，1）
    如果小球走到（6，5）就说明找到出路
    约定：当map[i][j]=0时，表示小球没走过，当=1时候表示是墙，=2表示是通路，可以走，3表示 这条路已经探测过 是不通的
    确定策略：先下然后右，上，左
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//此路已通
            return true;
        } else {
            if (map[i][j] == 0) {//没走过
                map[i][j] = 2;//先假设该点是可以走通的
                if (setWay(map, i + 1, j)) {//先往下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//右
                    return true;
                } else if (setWay(map, i - 1, j)) {//上
                    return true;
                } else if (setWay(map, i, j - 1)) {//左
                    return true;
                }else {//不通，死路
                    map[i][j]=3;
                    return false;
                }
            } else {//1，2，3
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int [][] map = new int[8][7];
        for (int i =0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i =0;i<8;i++){
            map[i][6]=1;
            map[i][0]=1;
        }
        int a =1;
        int b =1;
        setWay(map,a,b);
        for (int i= 0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
