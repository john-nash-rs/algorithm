class Solution {
    public int findTheWinner(int n, int k) {
        if(k==1){
            return n;
        }
        ListNode head =new ListNode(1);
        ListNode temp=head;
        for(int i=2; i<=n; i++){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        temp.next=head;
        int count=n;
        while(count>1){
            for(int i=1; i<k-1 ; i++){
                head=head.next;
            }
            head.next=head.next.next;
            head=head.next;
            --count;
        }
        return head.val;
    }
}