class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String text = "";        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'A') text += "B";
            else text += "A";
        }
        
        if (text.contains(pat)) return 1;
        return 0;
    }
}