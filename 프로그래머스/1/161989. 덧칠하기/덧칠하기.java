class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int target = 0;
        
        for (int s: section) {
            if (s <= target) {
                continue;
            }
            target = s + m - 1;
            answer++;
        }
        
        return answer;
    }
}