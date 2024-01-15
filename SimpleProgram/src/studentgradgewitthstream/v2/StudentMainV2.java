package studentgradgewitthstream.v2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMainV2 {

    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("5명 학생의 이름과 점수를 국어 영어 수학 순서대로 입력해주세요.");
        //String 배열 선언
        for (int i = 0; i < 5; i++) {
            String[] student = input.nextLine().split(" ");
            stuList.add(new Student(student[0], Integer.parseInt(student[1]), Integer.parseInt(student[2]), Integer.parseInt(student[3])));
        }

        System.out.print("\n학생들의 이름 : ");
        stuList.stream().map(Student::getName).forEach(student -> System.out.print(student + " "));

        List<Integer> korScoreList = stuList.stream().map(Student::getKorScore).toList();
        List<Integer> engScoreList = stuList.stream().map(Student::getEngScore).toList();
        List<Integer> mathScoreList = stuList.stream().map(Student::getMathScore).toList();

        System.out.println("\n\n===== 과목별 총 점수와 평균 =====");
        int korTotal = korScoreList.stream().mapToInt(Integer::valueOf).sum();
        int engTotal = engScoreList.stream().mapToInt(Integer::valueOf).sum();
        int mathTotal = mathScoreList.stream().mapToInt(Integer::valueOf).sum();

        Double korAverage = korScoreList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        Double engAverage = engScoreList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        Double mathAverage = mathScoreList.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        //출력
        System.out.printf("국어 점수 총합 : %d점, 평균 : %.2f점", korTotal, korAverage);
        System.out.printf("\n영어 점수 총합 : %d점, 평균 : %.2f점", engTotal, engAverage);
        System.out.printf("\n수학 점수 총합 : %d점, 평균 : %.2f점", mathTotal, mathAverage);

        System.out.println("\n\n========= 학생별 점수 =========");

        List<ExamResult> totalExam = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int totalScore = (korScoreList.get(i) + engScoreList.get(i) + mathScoreList.get(i));
            double averageScore = totalScore / 3.0;
            totalExam.add(new ExamResult(totalScore, averageScore));
        }

        System.out.println("번호    이름     국어  영어  수학  총점   평균");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d번  %3s %4d %4d %4d %4d  %3.2f\n",
                    i + 1,
                    stuList.get(i).getName(),
                    korScoreList.get(i),
                    engScoreList.get(i),
                    mathScoreList.get(i),
                    totalExam.get(i).getTotalScore(),
                    totalExam.get(i).getAverageScore());
        }
    }

}

