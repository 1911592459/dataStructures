package test;

class Node {
    String name;
    int id;
    Node next;

    public Node(String name, int id, Node next) {
        this.name = name;
        this.id = id;
        this.next = next;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", next=" + next +
                '}';
    }

    public Node(int id) {
        this.id = id;
    }
}

public class teste111 {

    public static void main(String[] args) {


        /*char a= 0x01;
        char b ='1';
        System.out.println(a);
        System.out.println(b);
        int c =a;
        int d=0x01;
        System.out.println(c);
        System.out.println(d);
        System.out.println(a==d);*/


    }

}
