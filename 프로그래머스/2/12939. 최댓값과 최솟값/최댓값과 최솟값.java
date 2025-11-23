class Solution {
    private StringBuilder answer = new StringBuilder();
    
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String num : s.split(" ")) {
            int cur = Integer.parseInt(num);
            if (min > cur) {
                min = cur;
            }
            if (max < cur) {
                max = cur;
            }
        }
        answer.append(min).append(" ").append(max);
        return answer.toString();
    }
}