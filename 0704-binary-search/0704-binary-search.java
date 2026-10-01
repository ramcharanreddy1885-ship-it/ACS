class Solution {
    public int search(int[] nums, int target) {
        int l,m,r;
        l = 0; r =nums.length - 1;
        while(l<=r){
            m = (l + r)/ 2;
            if(target == nums[m])
            return m;
        else 
            if(target > nums[m])
            l = m + 1;
        else
            r = m - 1;
        }
        return -1;
    }
}