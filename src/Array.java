public class Array<E> {
    private E[] data;
    private int size;

    //构造函数，传入数组容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
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
    public void addLast(E e){
        add(size,e);
    }

    //向所有元素前添加一个元素
    public void addFist(E e){
        add(0,e);
    }

    //在index的位置插入元素e，
    // 首先需要把索引位置及之后的位置都向后移动一个位置
    //从后往前移动元素
    //把需要插入元素的位置让出来
    //然后让数组大小+1

    public void add(int index,E e){
        if(index<0 || index >size)
            throw new IllegalArgumentException("AddLast failed.Index require >=0 and <=size");
        if(size==data.length)
            resize(2*data.length);
        for(int i = size-1;i>=index;i--)
            data[i+1] = data[i];
        data[index] = e;
        size++;
    }

    //获取index索引位置元素
    public E get(int index){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("Get failed.Index require >=0 and <=size");
        return data[index];
    }

    public void set(int index,E e){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("Get failed.Index require >=0 and <=size");
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找数组中元素e所在索引，如果不存在元素e,则返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index >=size)
            throw new IllegalArgumentException("Get failed.Index require >=0 and <=size");
        E ret = data[index];
        for(int i=index+1;i<size;i++)
            data[i-1]=data[i];
        size--;
        data[size]=null;
        if(size==data.length/2)
            resize(data.length/2);
        return ret;
    }

    //从数组中删除第一个元素，返回删除元素
    public E remveFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素，返回被删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override //覆盖父类方法
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i = 0;i<size;i++){
            res.append(data[i]);
        if(i != size-1)
            res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
       E[] newData = (E[])new Object[newCapacity];
       for(int i=0;i<size;i++)
           newData[i]=data[i];
       data = newData;
    }
}
