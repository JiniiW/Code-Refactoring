package programmers.lettercase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String answer = "";
        char[] array = new char[a.length()];

        for (int i = 0; i < a.length(); i++) {
            array[i] = a.charAt(i);
            if (array[i] >= 97 && array[i] <= 122) {
                array[i] = (char) (array[i]-32);
            } else if (array[i] >= 65 && array[i] <= 90) {
                array[i] = (char) (array[i]+32);
            }
        }
        System.out.println(array);
    }
}
