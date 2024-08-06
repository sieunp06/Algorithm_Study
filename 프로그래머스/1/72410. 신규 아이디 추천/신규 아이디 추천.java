class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for (char alpha : answer.toCharArray()) {
            if (alpha >= 'a' && alpha <= 'z') {
                sb.append(alpha);
                continue;
            } 
            if (alpha >= '0' && alpha <= '9') {
                sb.append(alpha);
                continue;
            } 
            if (alpha == '-' || alpha == '_' || alpha == '.') {
                sb.append(alpha);
                continue;
            }
        }
        answer = sb.toString();
        sb = new StringBuilder();
        boolean isDot = false;
        
        for (char alpha : answer.toCharArray()) {
            if (alpha == '.') {
                if (isDot) {
                    continue;
                } else {
                    isDot = true;
                    sb.append(alpha);
                }
            } else {
                sb.append(alpha);
                isDot = false;
            }
        }
        
        if (sb.length() != 0) {
            if (sb.charAt(0) == '.') {
                sb.delete(0, 1);
            }
        }
        if (sb.length() != 0) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.delete(sb.length() - 1, sb.length());
            }   
        }
        
        if (sb.length() == 0) {
            sb.append('a');
        }
        
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
        }
        
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.delete(sb.length() - 1, sb.length());
        }   
        
        if (sb.length() <= 2) {
            while (sb.length() < 3) {
                sb.append(sb.charAt(sb.length() - 1));
            }
        }
        return sb.toString();
    }
}