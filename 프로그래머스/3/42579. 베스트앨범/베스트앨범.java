import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, ArrayList<Music>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + plays[i]);
            if (map.containsKey(genre)) {
                ArrayList<Music> arr = map.get(genre);
                arr.add(new Music(i, plays[i]));
                map.put(genre, arr);
            } else {
                ArrayList<Music> arr = new ArrayList<>();
                arr.add(new Music(i, plays[i]));
                map.put(genre, arr);
            }
        }
        
        List<String> genreList = new ArrayList<>(genreTotal.keySet());
        genreList.sort(new Comparator<String>() {
            @Override
            public int compare(String g1, String g2) {
                return genreTotal.get(g2).compareTo(genreTotal.get(g1));
            }
        });
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < genreList.size(); i++) {
            ArrayList<Music> musicList = map.get(genreList.get(i));
            
            Collections.sort(musicList, new Comparator<Music> () {
                @Override
                public int compare(Music m1, Music m2) {
                    return m2.play - m1.play;
                }
            });
            
            if (musicList.size() == 1) {
                answerList.add(musicList.get(0).index);
            } else {
                for (int j = 0; j < 2; j++) {
                   answerList.add(musicList.get(j).index);
                }                
            }
        }

        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

class Music {
    int index;
    int play;
    
    Music(int index, int play) {
        this.index = index;
        this.play = play;
    }
}