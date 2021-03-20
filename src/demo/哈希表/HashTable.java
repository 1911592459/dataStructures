package demo.哈希表;

public class HashTable {
    public static void main(String[] args) {


    }
}

//哈希表，数组+链表的结构
class HashTab {
    private EmpLinkedList[] empLinkedListArray;//一个元素为链表的数组。
    private int size;

    public HashTab(int size) {//给哈希表的数组赋值长度
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    //给哈希表添加元素
    public void add(Emp emp) {
        int index = hashFun(emp.getId());
        empLinkedListArray[index].add(emp);

    }

    //散列函数，简单取模法，结果就是此次该员工在哈希表数组中的位置
    public int hashFun(int id) {
        return id % size;
    }
    //遍历哈希表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

}

//员工链表，假设每次进来的员工id都是从小到大自增的，所以每次都是添加到尾部即可。
class EmpLinkedList {
    private Emp head;

    //将该员工加入到此条链表尾部
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        curEmp.setNext(emp);
    }

    //遍历此条链表
    public void list() {
        if (head == null) {
            System.out.println("该链表为空");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.println(curEmp.getId() + ' ' + curEmp.getName());
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp.setNext(curEmp);
            System.out.println();
        }
    }
}


//员工表
class Emp {
    private Integer id;
    private String name;
    private Emp next;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}