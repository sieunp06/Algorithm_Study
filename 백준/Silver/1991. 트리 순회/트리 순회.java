import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static char[] left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        left = new char[26];
        right = new char[26];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char root = stringTokenizer.nextToken().charAt(0);
            char l = stringTokenizer.nextToken().charAt(0);
            char r = stringTokenizer.nextToken().charAt(0);

            int index = root - 'A';
            left[index] = l;
            right[index] = r;
        }

        preorder('A');
        stringBuilder.append("\n");
        inorder('A');
        stringBuilder.append("\n");
        postorder('A');

        System.out.print(stringBuilder);
    }

    private static void preorder(char node) {
        if (node == '.') return;
        stringBuilder.append(node);
        preorder(left[node - 'A']);
        preorder(right[node - 'A']);
    }

    private static void inorder(char node) {
        if (node == '.') return;
        inorder(left[node - 'A']);
        stringBuilder.append(node);
        inorder(right[node - 'A']);
    }

    private static void postorder(char node) {
        if (node == '.') return;
        postorder(left[node - 'A']);
        postorder(right[node - 'A']);
        stringBuilder.append(node);
    }
}
