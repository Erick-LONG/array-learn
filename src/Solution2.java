public class Solution2 {
    public ListNode203 removeElements(ListNode203 head, int val) {
        ListNode203 dummyHead = new ListNode203(-1);
        dummyHead.next = head;
        ListNode203 prev = dummyHead;
        while (prev.next !=null){
            if(prev.next.val ==val){
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }
        return dummyHead.next;

    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode203 head = new ListNode203(nums);
        System.out.println(head);
        ListNode203 res = (new Solution2()).removeElements(head,6);
        System.out.println(res);
    }
}
