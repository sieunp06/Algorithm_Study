import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] A, B;
    private static Deque<Integer> deque;

    public static void main(String[] args) throws Exception {
        init();
        findCommonSubSet();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        A = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        M = Integer.parseInt(bufferedReader.readLine());
        B = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        deque = new ArrayDeque<>();
    }

    private static void findCommonSubSet() {
        int idxA = 0;
        int idxB = 0;

        while (true) {
            int best = -1;
            int nextA = -1, nextB = -1;

            for (int num = 100; num >= 1; num--) {
                int aPos = findNextPos(A, idxA, num);
                int bPos = findNextPos(B, idxB, num);

                if (aPos != -1 && bPos != -1) {
                    best = num;
                    nextA = aPos + 1;
                    nextB = bPos + 1;
                    break;
                }
            }

            if (best == -1) break;

            deque.add(best);
            idxA = nextA;
            idxB = nextB;
        }
    }

    private static int findNextPos(int[] arr, int start, int target) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    private static void printAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(deque.size()).append("\n");
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst()).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
