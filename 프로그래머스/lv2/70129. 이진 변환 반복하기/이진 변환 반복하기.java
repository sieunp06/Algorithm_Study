class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while (!s.equals("1")) {
            answer[0]++;
            for (char alpha : s.toCharArray()) {
                if (alpha == '0') 
                    answer[1]++;
            }
            s = Integer.toBinaryString(s.replace("0", "").length());
        }
        return answer;
    }
}