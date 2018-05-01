public class Solution203 {
    public ListNode203 removeElements(ListNode203 head, int val) {
        while (head != null && head.val ==val){
            head = head.next;
        }
        if(head ==null)
            return null;

        ListNode203 prev = head;
        while (prev.next !=null){
            if(prev.next.val ==val){
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode203 head = new ListNode203(nums);
        System.out.println(head);
        ListNode203 res = (new Solution203()).removeElements(head,6);
        System.out.println(res);
    }
}
