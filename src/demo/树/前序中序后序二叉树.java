package demo.树;

public class 前序中序后序二叉树 {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        Node node4 = new Node(10);
        Node node5 = new Node(14);
        node.setLeft(node1);
        node.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node.midOrder();
    }
}

class Node {
    private int age;
    private String name;
    private Node left;
    private Node right;


    //递归删除节点
    public void delNode(int age) {
        if (this.left != null && this.left.age == age) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.age == age) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(age);
        }
        if (this.right != null) {
            this.right.delNode(age);
        }
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //前序查找
    public Node preSearch(int age) {
        if (this.age == age) {
            return this;
        }
        Node node = null;
        if (this.left != null) {
            node = this.left.preSearch(age);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.preSearch(age);
        }
        /*if (node != null) {
            return node;
        }
        return null;*/
        return node;

    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //中序查找
    public Node midSearch(int age) {
        Node node = null;
        if (this.left != null) {
            node = this.left.midSearch(age);
        }
        if (node != null) {
            return node;
        }
        if (this.age == age) {
            return this;
        }
        if (this.right != null) {
            node = this.right.midSearch(age);
        }

        return node;

    }


    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //后序查找
    public Node postSearch(int age) {
        System.out.println(1);
        Node node = null;
        if (this.left != null) {
            node = this.left.postSearch(age);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.postSearch(age);
        }
        if (node != null) {
            return node;
        }
        if (this.age == age) {
            return this;
        }
        return node;
    }

    public Node(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}