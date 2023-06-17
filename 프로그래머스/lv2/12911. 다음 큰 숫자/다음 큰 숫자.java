class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        int nCount = Integer.bitCount(n);
                
        while (true) {
            int count = Integer.bitCount(++num);
            if (nCount == count) {
                answer = num;
                break;
            }
        }
        
        return answer;
    }
}