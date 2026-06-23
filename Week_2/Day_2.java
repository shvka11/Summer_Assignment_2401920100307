import java.util.*;

public class Day_2 {
  //Question 1
   public int lengthOfLongestSubstring(String s) {
        Set<Character> data= new HashSet<>();
        int l=0 , max=0;
        for(int r=0; r<s.length(); r++ ){
            while(data.contains(s.charAt(r))){
                data.remove(s.charAt(l));
                l++;
            }
            data.add(s.charAt(r));
            max= Math.max(max,(r-l+1));
        }
        return max;
    }
  //Question 2
   public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n2 < n1) return false;

        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];

        for(int i = 0; i < n1; i++){
            alpha1[s1.charAt(i) - 'a']++;
            alpha2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(alpha1, alpha2)){
            return true;
        }

        for(int i = n1; i < n2; i++){
            alpha2[s2.charAt(i) - 'a']++;                 
            alpha2[s2.charAt(i - n1) - 'a']--;          
            if(Arrays.equals(alpha1, alpha2)) return true;
        }

        return false;

    }
// Question 3
   public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();  
        int n2 = p.length();  

        List<Integer> res = new ArrayList<>();

        if (n1 < n2) return res;
        int[] a1 = new int[26]; 
        int[] a2 = new int[26]; 

        for (int i = 0; i < n2; i++) {
            a1[p.charAt(i) - 'a']++;
            a2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a1, a2)) {
            res.add(0);
        }
        for (int i = n2; i < n1; i++) {
            a2[s.charAt(i) - 'a']++;           
            a2[s.charAt(i - n2) - 'a']--;     

            if (Arrays.equals(a1, a2)) {
                res.add(i - n2 + 1);
            }
        }

        return res;
    }
}
