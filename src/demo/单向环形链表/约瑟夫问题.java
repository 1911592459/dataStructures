package demo.单向环形链表;

public class 约瑟夫问题 {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList {
    Boy first = new Boy();


    //添加小孩结点，形成环形链表,每次都加到环形的最后，即first的后一个。
    public void addBoy(int nums) {
        if (nums < 1) {
            return;
        }
        Boy curBoy = null;
        for (int i = 0; i < nums; i++) {
            Boy boy = new Boy(i);
            if (i == 0) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//first不能动，让curboy帮助我们构成环
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        if (first == null) {
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();//后移
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序
    /*
     * startNo 从第几个小孩开始数数
     * countNum 数几下
     * nums 最初几个孩子在圈
     * */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数前，因为不一定是从第一个小孩开始报数，所以先将helper和first指到startNo的位置上
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //报数时，同时移动helper和first，移动countNum-1下
        while(true){
            if (helper==first){
                break;
            }
            for(int i =0;i<countNum-1;i++){
                helper=helper.getNext();
                first=first.getNext();
            }
            System.out.println(first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩："+helper.getNo());
    }
}

class Boy {
    int no;
    Boy next;

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy() {
    }

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    public Boy(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }
}
