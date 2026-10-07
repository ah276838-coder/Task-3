public class GradeChecker {

    public static String getGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "E";
    }

    public static boolean hasPassed(int score) {
        return score >= 50;
    }

    public static void printGradeReport(String candidateName, int score) {
        String grade = getGrade(score);
        String status = hasPassed(score) ? "PASSED" : "FAILED";
        System.out.println("Candidate: " + candidateName + " | Score: " + score + " | Grade: " + grade + " | Status: " + status);
    }
}
