class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for (int i = 2; i <= total; i++) {
            if (total % i == 0) {
                if ((i - 2) * (total / i - 2) == yellow) {
                    answer[0] = total / i;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}