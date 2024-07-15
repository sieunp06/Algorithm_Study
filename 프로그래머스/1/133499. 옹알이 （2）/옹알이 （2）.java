class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] text = {"aya", "ye", "woo", "ma"};
        
        for (String babb: babbling) {
            boolean flag = true;
            String replaced = babb;
            for (int i = 0; i < text.length; i++) {
                replaced = replaced.replaceAll(text[i], String.valueOf(i));
            }
            char[] alphabets = replaced.toCharArray();
            for (int j = 0; j < alphabets.length; j++) {
                if (!Character.isDigit(alphabets[j])) {
                    flag = false;
                    break;
                }
                if (j > 0) {
                    if (alphabets[j - 1] == alphabets[j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
}