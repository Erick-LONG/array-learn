public class Solution3 {
    public ListNode203 removeElements(ListNode203 head, int val) {
        if(head ==null)
            return null;
        ListNode203 res = removeElements(head.next,val);
        if(head.val ==val)
            return res;
        else {
            head.next = res;
            return head;
        }

    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode203 head = new ListNode203(nums);
        System.out.println(head);
        ListNode203 res = (new Solution3()).removeElements(head,6);
        System.out.println(res);
    }
}
