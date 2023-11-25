class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < word.length; j++) {
                String num = "" + j;
                babbling[i] = babbling[i].replaceAll(word[j], num);
            }
        }
        
        for (String babb : babbling) {
            String text = babb.replaceAll("[a-z]", "");
            if (text.length() == babb.length()) {
                boolean flag = true;
                for (int i = 1; i < text.length(); i++) {
                    if (text.charAt(i) == text.charAt(i - 1)) {
                        flag = false;
                    }
                }
                
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }
}