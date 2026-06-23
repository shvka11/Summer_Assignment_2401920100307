public class Day_1 {
  //Question 1
  public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i =0 ; i<s.length() ; i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i =0 ; i<t.length() ; i++){
            arr[t.charAt(i)-'a']--;
        }
        for(int i =0 ; i<26 ; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
  //Question 2
   public int firstUniqChar(String s) {
        int ch[] = new int[26];
        for(int i=0; i<s.length(); i++){
            ch[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(ch[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
  //Question 3
   public boolean canConstruct(String ransomNote, String magazine) {
        int ch[] = new int[26];
        for(int i=0; i<magazine.length(); i++){
            ch[magazine.charAt(i)-'a']++;
        }
        
        for(int i=0; i<ransomNote.length(); i++){
            if(ch[ransomNote.charAt(i)-'a'] == 0){
                return false;
            }
            ch[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }

}
