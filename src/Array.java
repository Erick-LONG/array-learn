public class Array {
    private int[] data;
    private int size;

    //构造函数，传入数组容量capacity构造Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    //无参数构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组中元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向所有元素后添加一个元素
    public void addLast(int e){
        add(size,e);
    }

    //向所有元素前添加一个元素
    public void addFist(int e){
        add(0,e);
    }

    //在index的位置插入元素e，
    // 首先需要把索引位置及之后的位置都向后移动一个位置
    //从后往前移动元素
    //把需要插入元素的位置让出来
    //然后让数组大小+1

    public void add(int index,int e){
        if(size==data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full");
        if(index<0 || index >size)
            throw new IllegalArgumentException("AddLast failed.Index require >=0 and <=size");
        for(int i = size-1;i>=index;i--)
            data[i+1] = data[i];
        data[index] = e;
        size++;
    }
}
