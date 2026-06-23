public class Day_3 {
  //Question 1
   public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
  //Question 2
   public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 == 0) return true;
        if(n1 > n2 ) return false;
        int idx = 0;

        for(int i = 0; i < n2; i++){
            if(t.charAt(i) == s.charAt(idx)){
                idx++;
            }
            if(idx == n1) return true;
        }
        return (idx == n1);
    }
  //Question 3
   public boolean repeatedSubstringPattern(String s) {
        String concatenated = s + s;
        return concatenated.substring(1, concatenated.length() - 1).contains(s);

    }
}
