class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int num = i; num <= j; num++) {
            String text = String.valueOf(num);
            for (char alpha : text.toCharArray()) {
                if (alpha - '0' == k) 
                    answer++;
            }
        }
        
        return answer;
    }
}