package studentgradgewitthstream.v1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMainV1 {

    public static void main(String[] args) {

        List<Student> stuList = new ArrayList<>();


        Scanner input = new Scanner(System.in);
        System.out.println("5명 학생의 이름과 점수를 국어 영어 수학 순서대로 입력해주세요.");
        for (int i = 0; i < 5; i++) {
            String stuName = input.next();
            Integer korScore = input.nextInt();
            Integer mathScore = input.nextInt();
            Integer engScore = input.nextInt();

            input.nextLine(); //추가

            stuList.add(new Student(stuName, korScore, mathScore, engScore));

        }


        System.out.print("\n학생들의 이름 : ");
        stuList.stream().map(Student::getName).forEach(student -> System.out.print(student + " "));

        System.out.println("\n\n===== 과목별 총점수와 평균 =====");
        List<Integer> studentsKorScore = stuList.stream().map(Student::getKorScore).toList();
        int korTotal = studentsKorScore.stream().mapToInt(Integer::intValue).sum();
        Double korAverage = studentsKorScore.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.printf(" 국어 점수 총합 : %d점 평균 : %.2f점", korTotal, korAverage);


        List<Integer> studentsEngScore = stuList.stream().map(Student::getEngScore).toList();
        int engTotal = studentsEngScore.stream().mapToInt(Integer::intValue).sum();
        Double engAverage = studentsEngScore.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.printf("\n 영어 점수 총합 : %d점 평균 : %.2f점", engTotal, engAverage);

        List<Integer> studentsMathScore = stuList.stream().map(Student::getMathScore).toList();
        int mathTotal = studentsMathScore.stream().mapToInt(Integer::intValue).sum();
        Double mathAverage = studentsMathScore.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.printf("\n 수학 점수 총합 : %d점 평균 : %.2f점", mathTotal, mathAverage);

        //toatlExam에 String으로 모두 저장
        List<String> totalExam = stuList.stream().map(student -> (stuList.indexOf(student) + 1) + "번  " + student.getName() + "   " + student.getKorScore() + "   " + student.getEngScore() + "   " + student.getMathScore()
                + "   " + (student.getKorScore() + student.getEngScore() + student.getMathScore())
                + "   " + ((student.getKorScore() + student.getEngScore() + student.getMathScore()) / 3.0)).toList();

        System.out.println("\n\n========= 학생별 점수 =========");
        System.out.println("번호    이름     국어  수학  영어   총점   평균");
        totalExam.stream().forEach(System.out::println);
    }
}

