import java.util.*;
public class Day_5 {
  //Question 1
   class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(s1.isEmpty()){
            s2.push(x);
        }else{
            s1.push(x);
        }
    }
    
    public int pop() {
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        int temp=-1;
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                temp = s2.pop();
                if(s2.isEmpty()){
                    break;
                }
                s1.push(temp);
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

        }else{
            while(!s1.isEmpty()){
                temp= s1.pop();
                if(s1.isEmpty()){
                    break;
                }
                s2.push(temp);
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return temp;
    }
    
    public int peek() {
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        int temp=-1;
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                temp = s2.pop();
                s1.push(temp);
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

        }else{
            while(!s1.isEmpty()){
                temp= s1.pop();
                s2.push(temp);
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return temp;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
  //Question 2
   class RecentCounter {
        private static final int[] records = new int[10000]; 
        private int start;
        private int end;
        
        public RecentCounter() {        
            start = 0;
            end = 0;
        }
        
        
        public int ping(int t) {
            while (start < end && (t - records[start] > 3000)) { 
                start++; 
            }
            records[end++] = t;
            return end - start;
        }
    }
  //Question 3
   class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; 
       
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0]; 
        right[n - 1] = nums[n - 1];
        
        for (int i = 1; i < n; ++i) {
           
            if (i % k == 0) left[i] = nums[i];
            else            left[i] = Math.max(left[i - 1], nums[i]);
            
            int j = n - i - 1;
            if (j % k == (k - 1)) right[j] = nums[j];
            else                  right[j] = Math.max(right[j + 1], nums[j]);
        }
        
        
        for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
            result[i] = Math.max(right[i], left[j]);
        }
        
        return result;
        }
}
}
