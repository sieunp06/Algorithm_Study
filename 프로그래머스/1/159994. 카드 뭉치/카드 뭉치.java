class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0; int idx2 = 0;
        for (String text: goal) {
            if (idx1 < cards1.length) {
                if (cards1[idx1].equals(text)) {
                    idx1++;
                    continue;
                }   
            }
            if (idx2 < cards2.length) {
                if (cards2[idx2].equals(text)) {
                    idx2++;
                    continue;
                }   
            }
            return "No";
        }
        
        return "Yes";
    }
}