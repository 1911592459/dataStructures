package demo.单链表的CRUD;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 单链表 {
    public static void main(String[] args) {
        SinglenLingkedList list = new SinglenLingkedList();
        Node node1 = new Node(1, new Node(3, new Node()));
        Node node2 = new Node(0);
        Node node = list.mergeList(node1, node2);
        System.out.println(node);
    }
}

class SinglenLingkedList {
    List list = new LinkedList();
    Node head = new Node("", 0);
    Node arr[] = new Node[5];
    int i = 0;

    @Override
    public String toString() {
        return "SinglenLingkedList{" +
                "list=" + list +
                ", head=" + head +
                '}';
    }

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

    //合并俩个有序单链表
    //并且合并后依然有序
    //方法1：递归
    public Node mergeList(Node node1, Node node2) {
        //这几个if必不可少
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node head = null;
        if (node1.id > node2.id) {
            head = node2;
            head.next = mergeList(node1, node2.next);
        } else {
            head = node1;
            head.next = mergeList(node1.next, node2);
        }
        return head;
    }

    //方法2：非递归
    public Node mergeTwoLists(Node node1, Node node2) {

        Node head = new Node();
        Node temp = head;
        while (node1 != null && node2 != null) {

            if (node1.id > node2.id) {
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            } else {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            }
        }
        if (node1==null){
            temp.next=node2;
        }else {
            temp.next=node1;
        }
        return head.next;
    }


    //单链表的反转
    //头插法，顺序遍历原链表，从原链表第一个开始取，放进反转链表的头，每次都插头，用next保存原链表即将插的下一个节点，这样cur改变后还能再回来
    public void reverseList(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        Node cur = head.next;
        Node next = null;
        Node reverseHead = new Node("", 0);
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }


    //单链表的倒序遍历
    //方法1：递归
    public Node[] reverse(Node head4) {
        if (head4 != null) {
            reverse(head4.next);
            arr[i] = head4;
            i++;
        }
        return arr;
    }

    //方法2：反转后再遍历，怕破坏原链表结构，可以将反转后的链表赋给一个新定义的
    public void reverse2(Node node) {
        SinglenLingkedList lingkedList = new SinglenLingkedList();
        lingkedList.reverseList(node);
        lingkedList.add(node);
        lingkedList.list();
    }

    //方法3：用栈先进后出的原理,优点：不破坏原链表的结构
    public void reverse3(Node head) {
        Stack stack = new Stack();
        Node node = head.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
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

    public Node(String name, int id, Node next) {
        this.name = name;
        this.id = id;
        this.next = next;
    }

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }

    public Node(int id) {
        this.id = id;
    }

    public Node() {
    }
}