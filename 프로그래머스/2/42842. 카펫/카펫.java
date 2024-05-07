class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        for (int i = 3; i < total; i++) {
            if (total % i == 0) {
                int x = total / i;
                int y = i;
                if ((x - 2) * (y - 2) == yellow) {
                    answer[0] = y;
                    answer[1] = x;
                }
            }
        }
        return answer;
    }
}