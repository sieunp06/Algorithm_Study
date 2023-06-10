class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int num : array) {
            String numSt = String.valueOf(num);
            for (Character alpha : numSt.toCharArray()) {
                if (alpha == '7') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}