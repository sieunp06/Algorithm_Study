class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++) {
            for (String sound : sounds) {
                if (babbling[i].contains(sound)) {
                    babbling[i] = babbling[i].replaceAll(sound, "_");
                } 
            }
        }
        
        for (String text : babbling) {
            int size = text.replaceAll("[a-z]", "").length();
            if (text.length() == size) {
                answer++;
            }
        }
        
        return answer;
    }
}