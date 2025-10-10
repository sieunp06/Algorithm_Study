class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while (!s.equals("1")) {
            String target = s.replaceAll("0", "");
            answer[1] += s.length() - target.length();
            s = Integer.toString(target.length(),  2);
            answer[0]++;
        }
        
        return answer;
    }
}