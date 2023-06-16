class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n + 1];
        
        for (int i = 1; i <= n; i++)
            numbers[i] = i;
        
        int total = 1;
        int start = 1;
        int end = 1;
        
        while (end <= n) {
            if (total == n) {
                answer++;
                total -= start++;
            } else if (total < n) {
                end++;
                total += end;
            } else {
                total -= start++;
            }
        }

        return answer;
    }
}