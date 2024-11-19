class Solution {
    public String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        
        boolean isAfterSpace = true;
        for (char alpha : s.toCharArray()) {
            if (isAfterSpace && alpha != ' ') {
                stringBuilder.append(Character.toUpperCase(alpha));
                isAfterSpace = false;
                continue;
            }
        
            stringBuilder.append(Character.toLowerCase(alpha));
            if (alpha == ' ') {
                isAfterSpace = true;
            }
        }
        
        return stringBuilder.toString();
    }
}