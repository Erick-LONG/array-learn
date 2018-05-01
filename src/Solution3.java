public class Solution3 {
    public ListNode203 removeElements(ListNode203 head, int val) {
        if(head ==null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val ==val ? head.next:head;
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode203 head = new ListNode203(nums);
        System.out.println(head);
        ListNode203 res = (new Solution3()).removeElements(head,6);
        System.out.println(res);
    }
}
