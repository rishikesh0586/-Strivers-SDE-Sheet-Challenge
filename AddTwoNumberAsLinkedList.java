class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           int c=0;
    ListNode head=new ListNode(0);
    ListNode l3=head,p1=l1,p2=l2;
    while(p1!=null||p2!=null){
        if(p1!=null){
         c+=p1.val;
         p1=p1.next;
        }
        if(p2!=null){
            c+=p2.val;
            p2=p2.next;
        }
        l3.next=new ListNode(c%10);
        l3=l3.next;
        c/=10; 
    }
    if(c==1){
        l3.next=new ListNode(1);
    
    }
    return head.next;
        
    }
}