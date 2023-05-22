class Solution {
    public int solution(int order) {
        int answer = 0;
        
        for (char alpha : String.valueOf(order).toCharArray()) {
            if (alpha == '3' || alpha == '6' || alpha == '9')
                answer++;
        }
        
        return answer;
    }
}