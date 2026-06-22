import java.util.Arrays;

public class Day_5 {
  //Question 1
   public boolean isPalindrome(String s) {
        int start =0 , end = s.length()-1;
        Character.toLowerCase(s.charAt(start));
        while(start<end){
            while(start<=end && !(Character.toLowerCase(s.charAt(start))>='a' && Character.toLowerCase(s.charAt(start)) <='z') && !Character.isDigit(s.charAt(start))){
                start++;
            }
             while(start <= end && !(Character.toLowerCase(s.charAt(end))>='a' && Character.toLowerCase(s.charAt(end)) <='z') && !Character.isDigit(s.charAt(end))){
                end--;
            }
            if(start < end && Character.toLowerCase(s.charAt(start++))!=Character.toLowerCase(s.charAt(end--))){
                return false;
            }
        }
        
        return true;
    }
  //Question 2
   public void reverseString(char[] s) {
        for(int i = 0 ; i<s.length/2 ; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
  //Question 3
  public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        for(int i=0; i<Math.min(strs[0].length(), strs[strs.length-1].length()); i++){
            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)){
                return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
