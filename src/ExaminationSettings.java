public class ExaminationSettings {
    static int examYear;
    static double registrationFee;
    static String gradingPolicy;

    static {
        System.out.println("=== STATIC BLOCK EXECUTING ===");
        examYear = 2026;
        registrationFee = 50000.0;
        gradingPolicy = "A: 80-100, B: 70-79, C: 60-69, D: 50-59, E: 0-49";

        System.out.println("Examination settings loaded.");
        System.out.println("Exam Year: " + examYear);
        System.out.println("Registration Fee: UGX " + registrationFee);
        System.out.println("Grading Policy: " + gradingPolicy);
        System.out.println();
    }
}

