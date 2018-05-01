public class Solution3 {
    public ListNode203 removeElements(ListNode203 head, int val,int depth) {
        String depthString = generateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call:remove" + val + "in" + head);
        if(head ==null) {
            System.out.print(depthString);
            System.out.println("Return:" +head);
            return head;
        }
        ListNode203 res = removeElements(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);
        ListNode203 ret;
        if(head.val ==val)
            ret = res;
        else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " +ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i =0;i<depth;i++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode203 head = new ListNode203(nums);
        System.out.println(head);
        ListNode203 res = (new Solution3()).removeElements(head,6,0);
        System.out.println(res);
    }
}
