import java.util.HashMap;

class Solution {
    
    HashMap<Integer,Integer> map = new HashMap<>();
    
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i] + 1));
            }
        }
        
        if (map.size() < (len / 2)){
            answer = map.size();
        } else {
            answer = len / 2;
        }
        
        
        return answer;
    }
}