class Solution {
    public boolean solution(String s) { 
        if (s.length() == 4 || s.length() == 6) {
            for (char alpha: s.toCharArray()) {
                if (!Character.isDigit(alpha))
                    return false;
            }
        } else {
            return false;
        }
        return true;
    }
}