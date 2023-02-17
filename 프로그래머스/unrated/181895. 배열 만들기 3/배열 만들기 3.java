import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int[] nums : intervals) {
            int startIdx = nums[0];
            int endIdx = nums[1];
            
            for (int i = startIdx; i <= endIdx; i++) {
                answer.add(arr[i]);
            }

        }
        
        return answer;
    }
}