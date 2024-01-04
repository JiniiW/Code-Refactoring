package baekjoon.quiz1157;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        word = word.toUpperCase();
        char[] array = new char[26];

        for (int i = 0; i < word.length(); i++) {
            array[word.charAt(i) - 65] += 1;
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                count++;
            }
        }

        if (count == 1) {
            System.out.println((char) (index + 65));
        } else {
            System.out.println("?");
        }

    }
}
