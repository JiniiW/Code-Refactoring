package studentgrade.refactoredcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student1 = new Student();

        System.out.print("학생의 이름을 입력하세요 : ");
        String name = input.nextLine();
        student1.setName(name);

        System.out.println("국어, 영어, 수학 점수를 순서대로 입력하세요");
        int kor = input.nextInt();
        int eng = input.nextInt();
        int math = input.nextInt();
        student1.setScore(kor, eng, math);

        double average = student1.setAverage();
        student1.setGrade();
        char grade = student1.getGrade();

        System.out.printf("%s 학생의 과목 평균은 %.2f이고, 학점은 %c입니다.", name, average, grade);

    }
}
