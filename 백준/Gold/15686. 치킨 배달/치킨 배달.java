import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<int[]> houses = new ArrayList<>();
    private static List<int[]> chickenRes = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (value == 1) {
                    houses.add(new int[] {i, j});
                } else if (value == 2) {
                    chickenRes.add(new int[] {i, j});
                }
            }
        }

        chooseChicken(0, 0, new ArrayList<>());
        System.out.println(min);
    }

    private static void chooseChicken(int start, int count, List<int[]> selected) {
        if (count == M) {
            min = Math.min(min, calChickenLen(selected));
            return;
        }

        for (int i = start; i < chickenRes.size(); i++) {
            selected.add(chickenRes.get(i));
            chooseChicken(i + 1, count + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private static int calChickenLen(List<int[]> selectedChicken) {
        int total = 0;
        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chicken : selectedChicken) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDist = Math.min(minDist, dist);
            }
            total += minDist;
        }
        return total;
    }
}
