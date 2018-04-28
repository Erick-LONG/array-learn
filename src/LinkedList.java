public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyhead;
    private int size;
    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    //获取链表元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在链表的index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作
    public void add(int index,E e){
        if(index<0 || index >size)
            throw new IllegalArgumentException("Add failed ,Illegal index.");

        Node prev = dummyhead;
        for(int i=0;i<index;i++)
            prev = prev.next;
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next =new Node(e,prev.next);
        size++;
        }

    //在链表头添加新的元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(size,e);
    }
}