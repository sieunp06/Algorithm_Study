import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());   // 임의로 만든 문자열의 길이
        int P = Integer.parseInt(st.nextToken());   // 사용할 부분 문자열의 길이

        char[] text = bf.readLine().toCharArray();  // 문자열 알파벳 배열

        st = new StringTokenizer(bf.readLine());

        int count = 0;
        int isAvailable = 0;

        int[] DNA = new int[4];
        int[] myDNA = new int[4];
        for (int i = 0; i < 4; i++) {
            DNA[i] = Integer.parseInt(st.nextToken());
            if (DNA[i] == 0) isAvailable++;
        }

        // 초기 슬라이딩 윈도우
        for (int i = 0; i < P; i++) {
            switch (text[i]) {
                case 'A':
                    myDNA[0]++;
                    if (DNA[0] == myDNA[0]) isAvailable++;
                    break;
                case 'C':
                    myDNA[1]++;
                    if (DNA[1] == myDNA[1]) isAvailable++;
                    break;
                case 'G':
                    myDNA[2]++;
                    if (DNA[2] == myDNA[2]) isAvailable++;
                    break;
                case 'T':
                    myDNA[3]++;
                    if (DNA[3] == myDNA[3]) isAvailable++;
                    break;
            }
        }
        if (isAvailable == 4) count++;

        for (int i = P; i < S; i++) {
            int j  = i - P;
            // 값 추가
            switch (text[i]) {
                case 'A':
                    myDNA[0]++;
                    if (DNA[0] == myDNA[0]) isAvailable++;
                    break;
                case 'C':
                    myDNA[1]++;
                    if (DNA[1] == myDNA[1]) isAvailable++;
                    break;
                case 'G':
                    myDNA[2]++;
                    if (DNA[2] == myDNA[2]) isAvailable++;
                    break;
                case 'T':
                    myDNA[3]++;
                    if (DNA[3] == myDNA[3]) isAvailable++;
                    break;
            }
            // 값 삭제
            switch (text[j]) {
                case 'A':
                    if (DNA[0] == myDNA[0]) isAvailable--;
                    myDNA[0]--;
                    break;
                case 'C':
                    if (DNA[1] == myDNA[1]) isAvailable--;
                    myDNA[1]--;
                    break;
                case 'G':
                    if (DNA[2] == myDNA[2]) isAvailable--;
                    myDNA[2]--;
                    break;
                case 'T':
                    if (DNA[3] == myDNA[3]) isAvailable--;
                    myDNA[3]--;
                    break;
            }
            if (isAvailable == 4) count++;
        }
        System.out.println(count);
    }
}