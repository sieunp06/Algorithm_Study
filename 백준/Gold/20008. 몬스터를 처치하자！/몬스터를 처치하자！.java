import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int HP;
    private static int[][] skills;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        HP = Integer.parseInt(st.nextToken());

        skills = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            skills[i][0] = Integer.parseInt(st.nextToken()); // 대기 시간
            skills[i][1] = Integer.parseInt(st.nextToken()); // 데미지
        }

        backtracking(HP, 0, new int[N]);
        System.out.println(answer);
    }

    private static void backtracking(int hp, int time, int[] cooldowns) {
        if (time >= answer) {
            return;
        }
        if (hp <= 0) {
            answer = Math.min(answer, time);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (cooldowns[i] == 0) {
                int[] clonedCooldown = cooldowns.clone();
                clonedCooldown[i] = skills[i][0];

                for (int j = 0; j < N; j++) {
                    if (clonedCooldown[j] > 0) {
                        clonedCooldown[j]--;
                    }
                }

                backtracking(hp - skills[i][1], time + 1, clonedCooldown);
            }
        }

        int[] clonedCooldown = cooldowns.clone();
        for (int j = 0; j < N; j++) {
            if (clonedCooldown[j] > 0) clonedCooldown[j]--;
        }
        backtracking(hp, time + 1, clonedCooldown);
    }
}
