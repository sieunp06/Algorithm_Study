import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        List<String> nums = new ArrayList<>();
        for (char num: String.valueOf(n).toCharArray()) {
            nums.add("" + num);
        }
        
        Collections.sort(nums, Collections.reverseOrder());
        
        return Long.parseLong(String.join("", nums));
    }
}