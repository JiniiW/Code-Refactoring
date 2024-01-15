package studentgradgewitthstream.v2;

public class ExamResult{

    //Student student;
    private Integer totalScore;
    private Double  averageScore;

    public ExamResult(Integer totalScore, Double averageScore) {
        this.totalScore = totalScore;
        this.averageScore = averageScore;
        //calculatorScore();
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public Double getAverageScore() {
        return averageScore;
    }

      //메서드 -> main에서 구현
/*    public void calculatorScore(){
        totalScore = student.getKorScore() + student.getEngScore() + student.getMathScore();
        averageScore = totalScore / 3.0;
   }*/
}
