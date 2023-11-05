class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (char alpha : my_string.toCharArray()) {
            if (alpha > 64 && alpha < 91) {
                answer[alpha - 65] ++;   
            } else {
                answer[alpha - 71]++;
            }
        }
        return answer;
    }
}