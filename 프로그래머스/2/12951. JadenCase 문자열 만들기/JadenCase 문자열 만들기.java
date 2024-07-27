class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        boolean spaceFlag = false;
        for (char alphabet: s.toCharArray()) {
            if (answer.length() == 0) {
                answer.append(Character.toUpperCase(alphabet));
                continue;
            }
            if (alphabet == ' ') {
                spaceFlag = true;
                answer.append(alphabet);
                continue;
            }
            if (spaceFlag) {
                answer.append(Character.toUpperCase(alphabet));
                spaceFlag = false;
                continue;
            }
            answer.append(Character.toLowerCase(alphabet));
        }
        
        return answer.toString();
    }
}