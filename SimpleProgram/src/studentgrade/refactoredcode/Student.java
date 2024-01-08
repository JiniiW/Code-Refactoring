package studentgrade.refactoredcode;

public class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private char grade;

    //이름 입력
    public void setName(String name) {
        this.name = name;
    }

    //점수 입력
    public void setScore(int kor, int eng, int math){
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    //총점
    public int setTotal(){
        int total = kor + eng + math;
        return total;
    }

    //평균
    public double setAverage(){
        double average = (double) setTotal() / 3;
        return average;
    }

    //학점
    public void setGrade(){
        switch ((int) (setAverage() / 10)){
            case 10, 9 -> this.grade = 'A';
            case 8 -> this.grade = 'B';
            case 7 -> this.grade = 'C';
            default -> this.grade = 'F';
        }
    }

    public char getGrade() {
        return grade;
    }
}
