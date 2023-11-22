import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int num : list) {
            int number = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    number++;
                }
            }
            if (number == 0) {
                answer++;
            }
        }

        return answer;
    }
}