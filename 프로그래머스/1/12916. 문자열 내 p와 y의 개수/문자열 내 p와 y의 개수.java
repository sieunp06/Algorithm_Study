class Solution {
    boolean solution(String s) {
        int numOfy = 0; int numOfp = 0;
        
        for (char alphabet: s.toLowerCase().toCharArray()) {
            if (alphabet == 'y') {
                numOfy++;
            }
            if (alphabet == 'p') {
                numOfp++;
            }
        }
        
        if (numOfy == numOfp) {
            return true;
        }
        return false;
    }
}