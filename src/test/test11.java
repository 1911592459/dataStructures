package test;


public class test11 {

    public static void main(String[] args) {
 /*       Node node =new Node(1);
        Node node1=node;
        Node node2=node;
        node1.next=new Node(2);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node);
*/
        Node node3 =new Node(3);
        Node pre =new Node(1);
        node3.next=pre;
        System.out.println(node3.next==pre);
        pre=node3;
        System.out.println(node3);





    }
}
class Node{
    Integer id;
    String age;
    Node next;

    public Node(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", next=" + next +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
