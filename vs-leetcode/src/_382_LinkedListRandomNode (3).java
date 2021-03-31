import java.util.Random;

public class _382_LinkedListRandomNode {
}

class Solution {
    Random r;
    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {//1->2->3
        r=new Random();
        this.head=head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count=0;
        ListNode res=head;
        ListNode p=head;
        while(p!=null){
            
            count++;
            if(r.nextInt()%count==0){
                res=p;
            }
            p=p.next;
        }

        return res.val;
    }
}