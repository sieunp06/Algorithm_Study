class Solution {
    public boolean solution(String s) {
        if (s.replaceAll("[0-9]", "").length() == 0 && (s.length() == 4 || s.length() == 6)) {
            return true;
        }
        return false;
    }
}