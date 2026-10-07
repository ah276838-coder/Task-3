public class GradeChecker {

    public static String getGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "E";
    }
}
