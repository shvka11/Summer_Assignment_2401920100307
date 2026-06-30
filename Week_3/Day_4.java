import java.util.*;
public class Day_4 {
  //Question 1
   public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        
        int n = temperatures.length;
        int ans[] = new int[n];
        s.push(n-1);
        for(int i = n-2; i>=0; i--){
            while(!s.isEmpty() ){
                if(temperatures[s.peek()] > temperatures[i]){
                    ans[i] = s.peek()-i;
                    break;
                }else{
                    s.pop();
                }
            }
            s.push(i);
        }
        return ans;
    }
  //Question 2
   public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int n= tokens.length;
        for(int i=0; i<n; i++){
            char ch = tokens[i].charAt(0);
            if((ch == '+' || ch == '-' || ch == '/' || ch == '*') && tokens[i].length() == 1){
                int a = s.pop();
                int b = s.pop();
                int temp = ch=='+'? b+a : (ch=='/'? b/a : (ch == '*'? a*b: b-a));
                s.push(temp);
            }else{
                int num = 0;
                int j=0;
                boolean flag = false;
                if(ch == '-'){
                    j++;
                    flag = true;
                }
                for( ; j<tokens[i].length(); j++){
                    num = (num*10)+(tokens[i].charAt(j) - '0');
                }
                if(flag){
                    num *= -1;
                }
                s.push(num);
            }
        }
        return res = s.pop();
    }
  //Question 3
   public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
