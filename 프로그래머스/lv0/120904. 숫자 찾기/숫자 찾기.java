class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        char[] texts = String.valueOf(num).toCharArray();
        String kk = String.valueOf(k);
        
        for (int i = 0; i < texts.length; i++) {
            if (texts[i] == kk.charAt(0))
                return i + 1;
        }
        
        return -1;
    }
}