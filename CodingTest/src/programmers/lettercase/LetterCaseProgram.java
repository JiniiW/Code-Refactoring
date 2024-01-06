package programmers.lettercase;

import java.util.Scanner;

public class LetterCaseProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String result = ""; //새로운 String 변수 선언

        //메서드 사용
        for(Character c : a.toCharArray()){
            if(Character.isUpperCase(c)){
                result += Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            }
        }
        System.out.println(result);
    }
}
