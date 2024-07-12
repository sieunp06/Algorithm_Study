class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                answer[i] = -1;
                continue;
            }
            char target = s.charAt(i);
            String sliced = s.substring(0, i);
            int idx = sliced.lastIndexOf(target);
            if (idx != -1) {
                answer[i] = i - idx;
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}