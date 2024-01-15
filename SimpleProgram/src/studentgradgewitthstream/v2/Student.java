package studentgradgewitthstream.v2;

public class Student {
    private String name;
    private Integer korScore;
    private Integer engScore;
    private Integer mathScore;


    public Student(String name, Integer korScore, Integer engScore, Integer mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public Integer getKorScore() {
        return korScore;
    }

    public Integer getEngScore() {
        return engScore;
    }
    public Integer getMathScore() {
        return mathScore;
    }

}


