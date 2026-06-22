public class Day_3 {
  // Question 1
  public void moveZeroes(int[] nums) {
        int n=nums.length;
        int k=0, j=0;
        while(k<n ){
            if(nums[k] != 0){
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                j++;
            }
            k++;
        }
        while(j<n){
            nums[j++]=0;
        }
    }
  //Question 2
   public int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int left=0 , right=nums.length-1;
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(Math.abs(nums[right]) > Math.abs(nums[left])){
                res[i] = nums[right]*nums[right];
                right--;
            }else{
                res[i] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
  //Question 3
   public int maxArea(int[] height) {
        int maxw=Integer.MIN_VALUE;
        int ls=0 ,rs=height.length-1;
        while(ls<rs){
            int w=rs-ls;
            int h=Math.min(height[rs],height[ls]);
            int water=w*h;
            maxw=Math.max(water,maxw);
            if(height[rs]>height[ls]){
                ls++;
            }else{
                rs--;
            }
        }
        return maxw;
    }
}
