class Solution {
    public int solution(int num) {
        long numLong = (long)num;
        int answer = 0;
        while (numLong != 1) {
            if (answer >= 500) return -1;
            if (numLong == 1) return 0;
            
            if (numLong % 2 == 0) {
                numLong /= 2;
                answer ++;
            }
            else {
                numLong *= 3;
                numLong++;
                answer ++;
            }
        }
        return answer;
    }
}