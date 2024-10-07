import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int size = getPocketmonSize(nums);
        if (size < nums.length / 2) {
            return size;
        }
        return nums.length / 2;
    }
    
    private int getPocketmonSize(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }
}