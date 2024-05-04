class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n + 1];
        
        if (n == 1) {
            return 1;
        }
        
        for (int i = 0; i <= n; i++) {
            numbers[i] = i;
        }
        
        int left = 1;
        int right = 2;
        int total = numbers[left] + numbers[right];
        
        while (right < n) {
            if (total == n) {
                answer++;
                total -= numbers[left];
                left++; right++;
                total += numbers[right];
            } else if (total < n) {
                right++;
                total += numbers[right];
            } else {
                total -= numbers[left];
                left++;
            }
        }
        
        return answer + 1;
    }
}