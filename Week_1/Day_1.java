public class Day_1 {
 
  //Question 1
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0 ; i<nums.length-1 ; i++){
            for(int j = i+1 ; j< nums.length ; j++){
                if(nums[i]+nums[j]==target){
                    int arr[] = {i,j};
                    return arr ;
                }
            }
        }
        int a[] ={0};
        return a;
    }
 //Question 2
    public static int removeDuplicates(int[] nums) {
        int idx = 0;
        for(int i = 0 ; i<nums.length ; i++){
            while(nums.length > i+1 && nums[i]==nums[i+1] ){
                i++;
            }
            nums[idx]=nums[i];
            idx++;
        }
        return idx;
    }
   //Question 3
    public static int maxProfit(int[] prices) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit=0;
    for(int i=0 ; i<prices.length ;i++){
        if(buyPrice < prices[i]){
            int profit = prices[i]-buyPrice ;
            maxProfit = Math.max(profit , maxProfit);
        }else{
            buyPrice = prices[i];
        }
    }  
    return maxProfit;
    }
}
