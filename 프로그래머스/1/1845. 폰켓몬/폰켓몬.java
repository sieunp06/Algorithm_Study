import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int target = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        
        if (map.size() < target) {
            return map.size();
        }
        return target;
    }
}