public class Day_2 {
   static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//Question 1
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = null;
        if(list1.val > list2.val){
            head = list2;
            list2 = list2.next;
        }else{
            head = list1;
            list1 = list1.next;
        }
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
            }else{
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        while(list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while(list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return head;
    }
  //Question 2
   public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        if(head.next == null ){
            head=null;
            return head;
        }
        ListNode temp = head;
        int c=0;
        ListNode head1 = head;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        int t=c-n-1;
        while(t>0){
            head1 = head1.next;
            t--;
        }
        if(t== -1){
            return head.next;
        }
        if(n==1){
            head1.next = null;
        }
        if(head1.next != null){
            ListNode res =head1.next;
            ListNode s = res.next;
            head1.next = s;
        }
        return head;

    }
  //Question 3
   public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr= slow;
        ListNode next;
        ListNode prev=null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode head1 = head;
        while(head1 != slow){
            if(prev.val != head1.val){
                return false;
            }
            prev = prev.next;
            head1 = head1.next;
        }
        return true;
    }
}
