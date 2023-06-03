class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for (char alpha : my_string.toCharArray()) {
            String emp = "";
            emp += alpha;
            if (!answer.contains(emp)) {
                answer += alpha;
            }
        }
        
        return answer;
    }
}