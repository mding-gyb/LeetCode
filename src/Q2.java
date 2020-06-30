import java.math.BigInteger;
public class Q2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        String num1 = "";
        String num2 = "";
        while (l1 != null){
            num1 = (Integer.toString(l1.val)) + num1;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            num2 = (Integer.toString(l2.val)) + num2;
            l2 = l2.next;
        }
        
        BigInteger sum = new BigInteger(num1).add(new BigInteger(num2));

        // System.out.println(sum);
        String sumstr = sum.toString();
        // System.out.println(sumstr);
        StringBuilder sums = new StringBuilder(); 
        sums.append(sumstr); 
        sums = sums.reverse(); 
        String str_sum = sums.toString();
        
        ListNode head = null;
        ListNode tail = null;
        
        for(int i = 0; i < str_sum.length(); i++){
            if (head == null){
                head = new ListNode(Integer.valueOf(String.valueOf(str_sum.charAt(i))));
                tail = head;
            } else {
                tail.next = new ListNode(Integer.valueOf(String.valueOf(str_sum.charAt(i))));
                tail = tail.next;
            }
        }
        return head;
    }
}
