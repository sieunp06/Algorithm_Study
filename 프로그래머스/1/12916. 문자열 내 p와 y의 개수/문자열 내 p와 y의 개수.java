class Solution {
    boolean solution(String s) {
        int numberOfP = 0;
        int numberOfY = 0;
        
        for (char alphabet : s.toUpperCase().toCharArray()) {
            if (alphabet == 'P') {
                numberOfP++;
            }
            if (alphabet == 'Y') {
                numberOfY++;
            }
        }
        
        if (numberOfP != numberOfY) {
            return false;
        }
        return true;
    }
}