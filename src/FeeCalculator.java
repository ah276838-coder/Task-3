public class FeeCalculator {

    public static double calculateFee(int numberOfSubjects) {
        double feePerSubject = ExaminationSettings.registrationFee / 10;
        double totalFee = numberOfSubjects * feePerSubject;
        System.out.println("Subjects: " + numberOfSubjects + " | Fee per subject: " + feePerSubject);
        return totalFee;
    }
}
