class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        int target = countOne(Integer.toString(n, 2));
        while (true) {
            if (target == countOne(Integer.toString(answer, 2))) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    private int countOne(String target) {
        int count = 0;
        for (char alpha : target.toCharArray()) {
            if (alpha == '1') {
                count++;
            }
        }
        return count;
    }
}