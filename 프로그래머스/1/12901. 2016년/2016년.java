class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = 0;
        for (int i = 0; i < a - 1; i++) {
            total += days[i];
        }
        total += b;
        
        if (total % 7 == 1) {
            answer = "FRI";
        } else if (total % 7 == 2) {
            answer = "SAT";
        } else if (total % 7 == 3) {
            answer = "SUN";
        } else if (total % 7 == 4) {
            answer = "MON";
        } else if (total % 7 == 5) {
            answer = "TUE";
        } else if (total % 7 == 6) {
            answer = "WED";
        } else if (total % 7 == 0) {
            answer = "THU";
        }
        
        return answer;
    }
}