import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] num = new int[n + 2];
        
        for (int lostNum: lost) {
            num[lostNum]--;
        }
        
        for (int reserveNum: reserve) {
            num[reserveNum]++;
        }
        
        for (int reserveNum: reserve) {
            if (num[reserveNum] == 0) {
                continue;
            }
            
            if (num[reserveNum - 1] < 0) {
                num[reserveNum - 1]++;
                continue;
            }
            if (num[reserveNum + 1] < 0) {
                num[reserveNum + 1]++;
                continue;
            }
        }
        
        for (int i = 1; i < num.length - 1; i++) {
            if (num[i] > -1) {
                answer++;
            }
        }
        
        return answer;
    }
}