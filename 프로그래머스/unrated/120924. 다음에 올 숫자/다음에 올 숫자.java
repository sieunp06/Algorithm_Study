class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        boolean is = common[1] - common[0] == common[2] - common[1];
        
        if (is) {   // 등차 수열
            answer = common[common.length - 1] + (common[1] - common[0]);
        } else {    // 등비 수열
            answer = common[common.length - 1] * (common[1] / common[0]);
        }
        
        return answer;
    }
}