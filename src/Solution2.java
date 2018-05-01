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
}
