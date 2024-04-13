class Solution {
    boolean solution(String s) {
        int numP = 0;
        int numY = 0;

        for (char alpha: s.toUpperCase().toCharArray()) {
            if (alpha == 'P') numP++;
            if (alpha == 'Y') numY++;
        }
        
        if (numP == numY) {
            return true;
        }
        return false;
    }
}