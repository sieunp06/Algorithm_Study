class Solution {
    public String solution(String[] seoul) {
        int index = -1;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        return makeResult(index);
    }
    
    private String makeResult(int index) {
        return "김서방은 " + index + "에 있다";
    }
}