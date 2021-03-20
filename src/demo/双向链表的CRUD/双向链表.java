package demo.双向链表的CRUD;

public class 双向链表 {
    public static void main(String[] args) {
        Node2 node1 =new Node2(0);
        Node2 node2 =new Node2(1);
        Node2 node3 =new Node2(2);
        Node2 node4 =new Node2(3);
        DoubleLinkedList list =new DoubleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.list();
        list.del(0);
        System.out.println("++++++++++++");
        list.list();
    }
}

class DoubleLinkedList {
    Node2 head = new Node2(0);




    //考虑插入顺序
    public void add1(Node2 node) {
        Node2 temp = head;
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
            if (temp.next!=null){
                node.next=temp.next;
                temp.next.pre=node;
                temp.next=node;
                node.pre=temp;
            }else{
                temp.next=node;
                node.pre=temp;
            }
        }
    }
    //删除节点
    public void del(int id) {
        Node2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的不存在");
        }
    }
    //修改节点信息，根据id来修改，id不可以修改，id修改其实就是新插入，不是修改

    public void modify(Node2 node) {
        //判断链表为空
        if (head.next == null) {
            return;
        }
        Node2 temp = head.next;
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

    public void add(Node2 node) {
        Node2 temp = head;
        //遍历找最后节点，直到找到才出循环。
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }
    //遍历链表

    public void list() {
        Node2 temp = head.next;

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
    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "head=" + head +
                '}';
    }
}

class Node2 {
    String name;
    int id;
    Node2 next;
    Node2 pre;


    @Override
    public String toString() {
        return "Node2{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Node2(int id, Node2 next, Node2 pre) {
        this.id = id;
        this.next = next;
        this.pre = pre;
    }

    public Node2(String name, int id, Node2 next, Node2 pre) {
        this.name = name;
        this.id = id;
        this.next = next;
        this.pre = pre;
    }

    public Node2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Node2(String name, int id, Node2 next) {
        this.name = name;
        this.id = id;
        this.next = next;
    }

    public Node2(int id, Node2 next) {
        this.id = id;
        this.next = next;
    }

    public Node2(int id) {
        this.id = id;
    }

    public Node2() {
    }
}
