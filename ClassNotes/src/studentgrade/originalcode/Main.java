package studentgrade.originalcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("2번 문제");
        System.out.print("학생 이름 : ");
        String name = sc.next();
        System.out.println("국어, 영어, 수학의 점수를 순서대로 입력하세요.");
        int kor = Integer.parseInt(sc.next());
        int eng = sc.nextInt();
        int mat = sc.nextInt();
        int total = kor + eng + mat;

        double avg = total / 3.0;
        char grade = 0;

        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg < 60){
            grade = 'F';
        }
        System.out.printf("%s 학생의 과목 평균은 %d점 이고 학점은 %c입니다.\n", name, avg, grade);
    }
}
