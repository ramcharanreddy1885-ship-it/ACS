class Solution {
    public void sortColors(int[] nums) {
        int x = 0,y = 0,z = 0,i;
        for(i = 0;i<nums.length;i++){
            if(nums[i] == 0)
            x++;
        else if(nums[i]==1)
            y++;
            else 
            z++;
        }
        i = 0;
        while(x>0){
            nums[i] = 0;
            i++;x--;
        }
        while(y>0){
            nums[i] = 1;
            y--;i++;
        }
        while(z>0){
            nums[i] = 2;
            z--;i++;
        }
        
    }
}