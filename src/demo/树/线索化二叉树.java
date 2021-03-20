package demo.树;

public class 线索化二叉树 {
    public static void main(String[] args) {
        ThreadedNode node = new ThreadedNode(1);
        ThreadedNode node2 = new ThreadedNode(3);
        ThreadedNode node3 = new ThreadedNode(6);
        ThreadedNode node4 = new ThreadedNode(8);
        ThreadedNode node5 = new ThreadedNode(10);
        ThreadedNode node6 = new ThreadedNode(14);
        node.setLeft(node2);
        node.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedNode threadedNode = new ThreadedNode();
        threadedNode.postThreadedTree(node);
        System.out.println(node3.getRight());
        threadedNode.posthreadedList(node);
    }
}

class ThreadedNode {
    private int age;
    private String name;
    private ThreadedNode left;
    private ThreadedNode right;

    //leftType=0/rightType=0表示指向的是左子树/右子树，1表示指向的是前驱节点/后继节点
    private int leftType;
    private int rightType;

    private ThreadedNode pre = null;

    //前序线索化二叉树
    public void preThreadedTree(ThreadedNode node) {
        if (node == null) {
            return;
        }
        //pre指针永远指向当前节点的前驱节点（上一个节点）
        //所以先让当前节点的左子节点线索化，就是直接让当前节点的左子节点指向pre
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //每次当前节点都只处理其左子节点的线索化，然后处理该节点的上一个节点的右线索化
        //即让pre（上一节点）的右节点指向当前节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //将当前节点作为pre（这里没有指向关系的改变，可以理解为只是相当于让当前节点又多了一个名字叫pre）
        pre = node;
        //System.out.println("pre: "+pre.getLeft());
        //(一)先线索化左子树
        if (node.getLeftType() != 1) {
            preThreadedTree(node.getLeft());
        }
        //(三)再线索化右子树
        if (node.getRightType() != 1) {
            preThreadedTree(node.getRight());
        }
    }

    //遍历前序线索二叉树
    public void prethreadedList(ThreadedNode node) {
        while (node != null) {
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            /*while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }*/
            node = node.getRight();
        }

    }

    //中序线索化二叉树
    public void midThreadedTree(ThreadedNode node) {
        if (node == null) {
            return;
        }

        midThreadedTree(node.getLeft());

        //pre指针永远指向当前节点的前驱节点（上一个节点）
        //所以先让当前节点的左子节点线索化，就是直接让当前节点的左子节点指向pre
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //每次当前节点都只处理其左子节点的线索化，然后处理该节点的上一个节点的右线索化
        //即让pre（上一节点）的右节点指向当前节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //将当前节点作为pre（这里没有指向关系的改变，可以理解为只是相当于让当前节点又多了一个名字叫pre）
        pre = node;
        //System.out.println("pre: "+pre.getLeft());

        midThreadedTree(node.getRight());
    }

    //遍历中序线索二叉树
    public void midthreadedList(ThreadedNode node) {
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }

    }

    //后序线索化二叉树
    public void postThreadedTree(ThreadedNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeftType() != 1) {
            postThreadedTree(node.getLeft());
        }
        //(三)再线索化右子树
        if (node.getRightType() != 1) {
            postThreadedTree(node.getRight());
        }
        //pre指针永远指向当前节点的前驱节点（上一个节点）
        //所以先让当前节点的左子节点线索化，就是直接让当前节点的左子节点指向pre
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //每次当前节点都只处理其左子节点的线索化，然后处理该节点的上一个节点的右线索化
        //即让pre（上一节点）的右节点指向当前节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //将当前节点作为pre（这里没有指向关系的改变，可以理解为只是相当于让当前节点又多了一个名字叫pre）
        pre = node;
        //System.out.println("pre: "+pre.getLeft());
    }


    //遍历后序线索二叉树
    public void posthreadedList(ThreadedNode node) {
        //用递归

    }

    public ThreadedNode() {
    }

    public ThreadedNode(int age) {
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

    public ThreadedNode getLeft() {
        return left;
    }


    @Override
    public String toString() {
        return "ThreadedNode{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadedNode getPre() {
        return pre;
    }

    public void setPre(ThreadedNode pre) {
        this.pre = pre;
    }
}