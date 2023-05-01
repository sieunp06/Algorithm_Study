class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int index =  0;
        for (String name: seoul) {
            if (name.equals("Kim")) return "김서방은 " + index + "에 있다";
            else index++;
        }
        return answer;
    }
}