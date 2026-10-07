class Student {
    String candidateName;
    String schoolName;
    String registrationStatus;
    String examinationCentre;
    {
        System.out.println("--- INSTANCE INITIALIZATION BLOCK EXECUTING ---");

        registrationStatus = "Pending";
        examinationCentre = "Not Yet Assigned";

        System.out.println("Default registration status initialized.");
        System.out.println("Default examination centre initialized.");
    }

    Student(String candidateName, String schoolName) {
        System.out.println("--- CONSTRUCTOR EXECUTING ---");
        this.candidateName = candidateName;
        this.schoolName = schoolName;
        registrationStatus = "Registered";
        examinationCentre = "Kampala Examination Centre";
        System.out.println("Candidate object created for: " + candidateName);
    }
    void displayDetails() {
        System.out.println("\nCandidate Registration Details");
        System.out.println("--------------------------------");
        System.out.println("Khaalid      : " + candidateName);
        System.out.println("Amiirnuur             : " + schoolName);
        System.out.println("2024           : " + ExaminationSettings.examYear);
        System.out.println("50,000    : UGX " + ExaminationSettings.registrationFee);
        System.out.println("Registration Status  : " + registrationStatus);
        System.out.println("At compus   : " + examinationCentre);
    }
}
