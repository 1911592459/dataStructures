package demo.链表模拟栈;

import java.util.Stack;

public class LinkedListStack {
    public static void main(String[] args) {
        SingleLinkedStack list = new SingleLinkedStack();
        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(2);
        Node1 node3 = new Node1(3);
        Node1 node4 = new Node1(0);
        list.push(node1);
        list.push(node2);
        System.out.println(list.toString());
    }
}

class SingleLinkedStack {
    Node1 top = new Node1(-1);

    @Override
    public String toString() {
        return "SingleLinkedStack{" +
                "top=" + top +
                '}';
    }

    //头插法
    public void push(Node1 node) {
        Node1 temp = top;
        if (temp.getNext()==null){//第一次插入
            temp.setNext(node);
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }


}

class Node1 {
    int id;
    Node1 next;

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }

    public Node1(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }

    public Node1() {
    }

    public Node1(int id, Node1 next) {
        this.id = id;
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}