import java.util.Arrays;

public class Day_2 {
   //Question 1
    public int maxSubArray(int[] nums) {
        int max= Integer.MIN_VALUE , curr=0;
        for(int i=0 ;i<nums.length ; i++){
            curr += nums[i];
            max =Math.max(max,curr);
            if(curr<0){
                curr=0;
            }
        }
        return max;
    }
   //Question 2
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    //Question 3
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        double sum = 0;
        for(int i=0; i<k; i++){
            ans += nums[i];
        }
        sum = ans;
        ans /= k;
        for(int i = k, j=0; i<nums.length; i++,j++){
            sum = sum - nums[j];
            sum += nums[i];
            ans = Math.max(ans, sum/k);
        }
        return ans;
    }
}
