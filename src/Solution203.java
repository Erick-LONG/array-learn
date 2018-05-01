public class Solution203 {
    public ListNode203 removeElements(ListNode203 head, int val) {
        while (head != null && head.val ==val){
            ListNode203 delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if(head ==null)
            return null;

        ListNode203 prev = head;
        while (prev.next !=null){
            if(prev.next.val ==val){
                ListNode203 delNode =prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else
                prev = prev.next;
        }
        return head;

    }
}
