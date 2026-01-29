import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer>[] party, personParty;
    private static boolean[] knowsTruth, visitedParty;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        party = new List[M];
        personParty = new List[N];

        for (int i = 0; i < M; i++) party[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) personParty[i] = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        knowsTruth = new boolean[N];

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            int p = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            knowsTruth[p] = true;
            q.add(p);
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int cnt = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < cnt; j++) {
                int person = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                party[i].add(person);
                personParty[person].add(i);
            }
        }

        visitedParty = new boolean[M];

        while (!q.isEmpty()) {
            int person = q.poll();

            for (int pIdx : personParty[person]) {
                if (visitedParty[pIdx]) continue;
                visitedParty[pIdx] = true;

                for (int other : party[pIdx]) {
                    if (!knowsTruth[other]) {
                        knowsTruth[other] = true;
                        q.add(other);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : party[i]) {
                if (knowsTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }
}
