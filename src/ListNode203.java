public class ListNode203 {
    int val;
    ListNode203 next;
    ListNode203(int x) { val = x; }

    //链表节点的构造函数
    //使用arr为参数，创建一个链表，当前的ListNode为链表头节点
    public ListNode203(int[] arr){
        if(arr ==null || arr.length==0)
            throw new IllegalArgumentException("arr can not be empty");
        this.val = arr[0];
        ListNode203 cur = this;
        for(int i =1;i<arr.length;i++){
            cur.next = new ListNode203(arr[i]);
            cur = cur.next;
        }
    }

    //以当前节点为头节点的链表信息字符串
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode203 cur = this;
        while (cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

