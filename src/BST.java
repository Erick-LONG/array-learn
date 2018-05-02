import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //在二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root,e);
    }

    //向以node为根的二分搜索树中插入元素E,递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){
        if(node ==null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) <0)
            node.left = add(node.left,e);
        else if(e.compareTo(node.e) >0)
            node.right = add(node.right,e);
        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }
    //看以node为根的二分搜索树中是否包含元素e,递归算法
    private boolean contains(Node node,E e){
        if(node==null)
            return false;
        if(e.compareTo(node.e)==0)
            return true;
        else if(e.compareTo(node.e) <0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node){
        if(node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树非递归遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    //二分搜索树中序遍历
    public void inOrder(){
        inOrder(root);
    }

    //以node为根的二分搜索树，递归算法
    private void inOrder(Node node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //二分搜索树的后序遍历
    private void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left !=null)
                q.add(cur.left);
            if(cur.right !=null)
                q.add(cur.right);
        }
    }

    //寻找二分搜索树最小元素
    public E minium(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty!");
        return minium(root).e;
    }

    //返回以node为根的二分搜索树的最小值所在节点
    private Node minium(Node node){
        if(node.left ==null)
            return node;
        return minium(node.left);

    }

    //寻找二分搜索树最大元素
    public E maxium(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty!");
        return maxium(root).e;
    }

    //返回以node为根的二分搜索树的最大值所在节点
    private Node maxium(Node node){
        if(node.right ==null)
            return node;
        return maxium(node.right);

    }

    //从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin(){
        E ret = minium();
        removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中最小的节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left ==null){
            Node rightNode = node.right;
            node.right= null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax(){
        E ret = maxium();
        removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中最小的节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right ==null){
            Node leftNode = node.left;
            node.left= null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node ==null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }
}
