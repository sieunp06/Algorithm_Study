package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String text = bf.readLine();
        char[] text_char = text.toCharArray();
        Queue<Character> q = new LinkedList<>();

        int len = text.length();
        int answer = 1;

        for (int i = 0; i < len / 2; i++)
            q.offer(text_char[i]);

        for (int i = len - 1; i >= len - len / 2; i--) {
            if (text_char[i] != q.poll())
                answer = 0;
        }

        System.out.println(answer);
    }
}