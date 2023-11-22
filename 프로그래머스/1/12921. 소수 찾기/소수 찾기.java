class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] nums = new int[n + 1];
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == 1) {
                continue;
            }
            
            for (int j = 2 * i; j < nums.length; j += i) {
                nums[j] = 1;
            }
        }
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}