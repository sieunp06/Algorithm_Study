class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardTurn1 = 0; int cardTurn2 = 0;
        
        for (String text : goal) {
            if (cardTurn1 < cards1.length) {
                if (text.equals(cards1[cardTurn1])) {
                    cardTurn1++;
                    continue;
                }   
            }
            if (cardTurn2 < cards2.length) {
                if (text.equals(cards2[cardTurn2])) {
                    cardTurn2++;
                    continue;
                }   
            }
            return "No";
        }
        
        return "Yes";
    }
}