public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i =0;i<arr.length;i++)
            data[i] = arr[i];
        tree =(E[])new Object[4*arr.length];//如果区间有N个元素，数组表示需要4n的空间
        buildSegmentTree(0,0,data.length-1);
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树
    public void buildSegmentTree(int treeIndex,int l,int r){
        if (l==r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r-l) / 2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid + 1,r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        return data[index];
    }

    private int leftChild(int index){
        return 2 * index+1;
    }

    private int rightChild(int index){
        return 2 * index+2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL,int queryR){
        return query(0,0,data.length-1,queryL,queryR);
    }

    //在以treeID为根的线段树中[l...r]范围里，搜索区间[queryL,queryR]的值
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        if (l ==queryL && r==queryR){
            return tree[treeIndex];
        }
        int mid = l + (r-l) /2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL>=mid +1)
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        else if (queryR<=mid)
            return query(leftTreeIndex,l,mid,queryL,queryR);

        E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
        E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftResult,rightResult);
    }
}
