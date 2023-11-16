class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        
        return process2(process1(x1, x2), process1(x3, x4));
    }
    
    private boolean process1(boolean x1, boolean x2) {
        if (x1 || x2) {
            return true;
        }
        return false;
    }
    
    private boolean process2(boolean x1, boolean x2) {
        if (!x1 || !x2) {
            return false;
        }
        return true;
    }
}