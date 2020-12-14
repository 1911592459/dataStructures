package demo.单链表的CRUD;


import java.util.LinkedList;
import java.util.List;

public class 单链表 {
    public static void main(String[] args) {
        SinglenLingkedList list = new SinglenLingkedList();
        Node node = new Node("san", 0);
        Node node2 = new Node("zhangsan", 1);
        Node node3 = new Node("zhang1san", 4);
        Node node54 = new Node("zhang2san", 3);
        Node node4 = new Node("zhang333san", 2);
        list.add1(node2);
        list.add1(node3);
        list.reverse2(list.head);

    }
}

class SinglenLingkedList {
    List list =new LinkedList();
    Node head = new Node("", 5);
    Node arr[] =new Node[5];
    int i=0;
    //遍历链表
    public void list() {
        Node temp = head.next;

        if (temp == null) {
            return;
        }
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //单链表的反转
    //头插法，顺序遍历原链表，从原链表第一个开始取，放进反转链表的头，每次都插头，用next保存原链表即将插的下一个节点，这样cur改变后还能再回来
    public void reverseList(Node head) {
        if (head.next==null||head.next.next==null){
            return ;
        }
        Node cur =head.next;
        Node next=null;
        Node reverseHead = new Node("",0);
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }


    //单链表的倒序遍历
    //方法1：递归
    public Node[] reverse(Node head4) {
        if (head4 != null) {
            reverse(head4.next);
            arr[i]=head4;
            i++;
        }
        return arr;
    }
    //方法2：反转后再遍历
    public void reverse2(Node node){
        SinglenLingkedList lingkedList = new SinglenLingkedList();
        lingkedList.reverseList(node);
        lingkedList.add(node);
        lingkedList.list();
    }

    //查找单链表中的倒数第K个节点
    public Node findKNode(Node head2, int k) {
        if (head2.next == null) {
            return null;
        }
        int size = getNum(head2);
        if (k <= 0 || k > size) {
            return null;
        }
        Node temp = head2.next;
        for (int i = 0; i < (size - k); i++) {
            temp = temp.next;
        }
        return temp;


    }

    //求单链表的节点个数，带头节点的的链表 *不统计头节点!!!*
    public static int getNum(Node head1) {
        if (head1.next == null) {
            return 0;
        }
        int sum = 0;
        Node temp = head1;
        while (temp.next != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }

    //删除节点
    public void del(int id) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的不存在");
        }
    }

    //修改节点信息，根据id来修改，id不可以修改，id修改其实就是新插入，不是修改
    public void modify(Node node) {
        //判断链表为空
        if (head.next == null) {
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
        } else {
            System.out.println("没有找到");
        }
    }

    //不考虑顺序，直接添加到链表的最后
    public void add(Node node) {
        Node temp = head;
        //遍历找最后节点，直到找到才出循环。
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;

    }

    //考虑插入顺序
    public void add1(Node node) {
        Node temp = head;
        boolean flag = false;//判断该编号是否已存在，默认不存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                flag = true;//已存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("已存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

}

class Node {
    String name;
    int id;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", next=" + next +
                '}';
    }

    public Node(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Node() {
    }
}