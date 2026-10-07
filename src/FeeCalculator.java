public class FeeCalculator {

    public static double calculateFee(int numberOfSubjects) {
        double feePerSubject = ExaminationSettings.registrationFee / 10;
        double totalFee = numberOfSubjects * feePerSubject;
        System.out.println("Subjects: " + numberOfSubjects + " | Fee per subject: " + feePerSubject);
        return totalFee;
    }

    public static void printFeeReceipt(String candidateName, int numberOfSubjects) {
        double total = calculateFee(numberOfSubjects);
        System.out.println("========== FEE RECEIPT ==========");
        System.out.println("Candidate : " + candidateName);
        System.out.println("Subjects  : " + numberOfSubjects);
        System.out.println("Total Fee : UGX " + total);
        System.out.println("Exam Year : " + ExaminationSettings.examYear);
        System.out.println("=================================");
    }
}
