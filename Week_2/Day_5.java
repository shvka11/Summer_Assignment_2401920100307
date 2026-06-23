import java.util.*;

public class Day_5 {
  //Question 1
   public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(i);

        }
        int idx=-1;
        List<List<String>> res = new ArrayList<>();
        for (String k : map.keySet()) {
            List<Integer> a = map.get(k);
            if(a.size() >0){
                res.add(new ArrayList<>());
                idx++;
                for(int i=0; i<a.size(); i++){
                    res.get(idx).add(strs[a.get(i)]);
                }
            }
            
        }
        return res;
    }
  //Question 2
   public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, read = 0;
        
        while (read < n) {
            char curr = chars[read];
            int count = 0;

           do {
                read++;
                count++;
            } while (read < n && chars[read] == curr);

           chars[write++] = curr;

          if (count > 1) {
                int start = write;
                while (count > 0) {
                    chars[write++] = (char) ('0' + count % 10);
                    count /= 10;
                }
             int end = write - 1;
                while (start < end) {
                    char temp = chars[start];
                    chars[start++] = chars[end];
                    chars[end--] = temp;
                }
            }
        }
        return write;
    }
// Question 3
   public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
