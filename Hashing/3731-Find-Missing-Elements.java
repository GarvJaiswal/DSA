class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        for(int ele:nums){
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                ans.add(i);
    
            }
        }
        return ans;
    }
}