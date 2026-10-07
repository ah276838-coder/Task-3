// ============================================================
// UNEB Candidate Registration System
// Demonstrates:
//   1. Static blocks & static fields/methods
//   2. Instance initialization blocks
//   3. Constructor overloading
//   4. Inheritance (super()) with UCE and UACE candidates
//   5. ArrayList-based candidate registry
// ============================================================

import java.util.ArrayList;

// ---------------------------------------------------------------
// CLASS: ExaminationSettings
// Holds application-wide constants loaded once via a static block.
// ---------------------------------------------------------------
class ExaminationSettings {

    static int    examYear;
    static double registrationFee;
    static double uaceRegistrationFee;   // UACE fee is higher
    static String gradingPolicy;

    // STATIC BLOCK — runs once when the class is first accessed.
    static {
        System.out.println("=== [ExaminationSettings] STATIC BLOCK EXECUTING ===");

        examYear            = 2026;
        registrationFee     = 50_000.0;   // UCE fee
        uaceRegistrationFee = 75_000.0;   // UACE fee
        gradingPolicy       = "A: 80-100, B: 70-79, C: 60-69, D: 50-59, F: 0-49";

        System.out.println("Examination settings loaded.");
        System.out.println("Exam Year           : " + examYear);
        System.out.println("UCE  Fee            : UGX " + registrationFee);
        System.out.println("UACE Fee            : UGX " + uaceRegistrationFee);
        System.out.println("Grading Policy      : " + gradingPolicy);
        System.out.println();
    }
}

// ---------------------------------------------------------------
// CLASS: Student  (base class)
// ---------------------------------------------------------------
class Student {

    // ----- Fields -----
    String candidateName;
    String schoolName;
    String registrationStatus;
    String examinationCentre;
    String indexNumber;

    // Static counter — shared across ALL Student objects.
    static int totalRegistered = 0;

    // INSTANCE INITIALIZATION BLOCK
    // Runs before EVERY constructor of this class (and subclasses).
    {
        System.out.println("  [Student] Instance block: setting defaults.");
        registrationStatus = "Pending";
        examinationCentre  = "Not Yet Assigned";
        indexNumber        = "Not Yet Assigned";
    }

    // ----- Constructor 1: name + school (centre auto-assigned) -----
    Student(String candidateName, String schoolName) {
        System.out.println("  [Student] Constructor 1 (auto-centre) executing.");
        this.candidateName    = candidateName;
        this.schoolName       = schoolName;
        this.registrationStatus = "Registered";
        this.examinationCentre  = "Kampala Examination Centre";
        totalRegistered++;
        System.out.println("  Candidate created: " + candidateName);
    }

    // ----- Constructor 2: name + school + custom centre -----
    Student(String candidateName, String schoolName, String examinationCentre) {
        System.out.println("  [Student] Constructor 2 (custom-centre) executing.");
        this.candidateName      = candidateName;
        this.schoolName         = schoolName;
        this.registrationStatus = "Registered";
        this.examinationCentre  = examinationCentre;
        totalRegistered++;
        System.out.println("  Candidate created: " + candidateName
                           + " | Centre: " + examinationCentre);
    }

    // ----- Static method: report total registered -----
    static void printTotalRegistered() {
        System.out.println(">> Total candidates registered so far: " + totalRegistered);
    }

    // ----- Display method (overrideable) -----
    void displayDetails() {
        System.out.println("\n  Candidate Registration Details");
        System.out.println("  --------------------------------");
        System.out.println("  Candidate Name     : " + candidateName);
        System.out.println("  School             : " + schoolName);
        System.out.println("  Index Number       : " + indexNumber);
        System.out.println("  Exam Year          : " + ExaminationSettings.examYear);
        System.out.println("  Registration Status: " + registrationStatus);
        System.out.println("  Examination Centre : " + examinationCentre);
    }
}

// ---------------------------------------------------------------
// CLASS: UCECandidate  (extends Student)
// Represents an Ordinary-Level (S.4) candidate.
// ---------------------------------------------------------------
class UCECandidate extends Student {

    String subjectCombination;   // e.g., "English, Math, Biology, Chemistry, Physics"
    double feePaid;

    // INSTANCE INITIALIZATION BLOCK — runs before UCECandidate constructors
    {
        System.out.println("  [UCECandidate] Instance block: setting UCE defaults.");
        subjectCombination = "Not Yet Selected";
        feePaid            = 0.0;
    }

    // Constructor — calls super() then sets UCE-specific fields.
    UCECandidate(String candidateName, String schoolName,
                 String examinationCentre, String subjectCombination) {

        super(candidateName, schoolName, examinationCentre); // calls Student constructor 2
        System.out.println("  [UCECandidate] Constructor executing.");

        this.subjectCombination = subjectCombination;
        this.feePaid            = ExaminationSettings.registrationFee;
        // Assign UCE index format
        this.indexNumber = "UCE/" + ExaminationSettings.examYear
                           + "/" + String.format("%04d", totalRegistered);
    }

    @Override
    void displayDetails() {
        super.displayDetails();   // print base fields first
        System.out.println("  Level              : UCE (Ordinary Level - S.4)");
        System.out.println("  Subjects           : " + subjectCombination);
        System.out.println("  Registration Fee   : UGX " + feePaid);
    }
}

// ---------------------------------------------------------------
// CLASS: UACECandidate  (extends Student)
// Represents an Advanced-Level (S.6) candidate.
// ---------------------------------------------------------------
class UACECandidate extends Student {

    String principalSubjects;    // e.g., "Physics, Chemistry, Mathematics"
    String subsidiarySubjects;   // e.g., "General Paper, ICT"
    double feePaid;

    // INSTANCE INITIALIZATION BLOCK — runs before UACECandidate constructors
    {
        System.out.println("  [UACECandidate] Instance block: setting UACE defaults.");
        principalSubjects  = "Not Yet Selected";
        subsidiarySubjects = "Not Yet Selected";
        feePaid            = 0.0;
    }

    // Constructor — calls super() then sets UACE-specific fields.
    UACECandidate(String candidateName, String schoolName,
                  String examinationCentre,
                  String principalSubjects, String subsidiarySubjects) {

        super(candidateName, schoolName, examinationCentre); // calls Student constructor 2
        System.out.println("  [UACECandidate] Constructor executing.");

        this.principalSubjects  = principalSubjects;
        this.subsidiarySubjects = subsidiarySubjects;
        this.feePaid            = ExaminationSettings.uaceRegistrationFee;
        // Assign UACE index format
        this.indexNumber = "UACE/" + ExaminationSettings.examYear
                           + "/" + String.format("%04d", totalRegistered);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("  Level              : UACE (Advanced Level - S.6)");
        System.out.println("  Principal Subjects : " + principalSubjects);
        System.out.println("  Subsidiary Subjects: " + subsidiarySubjects);
        System.out.println("  Registration Fee   : UGX " + feePaid);
    }
}

// ---------------------------------------------------------------
// CLASS: CandidateRegistry
// Stores all registered candidates and prints a summary report.
// ---------------------------------------------------------------
class CandidateRegistry {

    private ArrayList<Student> candidates = new ArrayList<>();

    void register(Student s) {
        candidates.add(s);
    }

    void printSummaryReport() {
        System.out.println("\n==============================================");
        System.out.println("        CANDIDATE REGISTRY SUMMARY");
        System.out.println("==============================================");
        System.out.printf("  %-5s %-22s %-12s %-30s%n",
                          "#", "Candidate Name", "Index No.", "Examination Centre");
        System.out.println("  " + "-".repeat(72));

        int i = 1;
        for (Student s : candidates) {
            System.out.printf("  %-5d %-22s %-12s %-30s%n",
                              i++, s.candidateName, s.indexNumber, s.examinationCentre);
        }

        System.out.println("  " + "-".repeat(72));
        System.out.println("  Total candidates listed: " + candidates.size());
        System.out.println("==============================================\n");
    }
}

// ---------------------------------------------------------------
// CLASS: Main  (entry point)
// ---------------------------------------------------------------
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("   UNEB CANDIDATE REGISTRATION SYSTEM  v2.0");
        System.out.println("==============================================\n");

        // Accessing ExaminationSettings triggers its static block once.
        System.out.println("Application started. Loading config...\n");
        System.out.println("Exam Year: " + ExaminationSettings.examYear + "\n");

        CandidateRegistry registry = new CandidateRegistry();

        // ---- UCE Candidates ----------------------------------------
        System.out.println("----------------------------------------------");
        System.out.println("Registering UCE Candidate 1...");
        System.out.println("----------------------------------------------");
        UCECandidate uce1 = new UCECandidate(
                "John Mugisha",
                "Makerere College School",
                "Kampala Examination Centre",
                "English, Mathematics, Biology, Chemistry, Physics"
        );
        uce1.displayDetails();
        registry.register(uce1);
        Student.printTotalRegistered();

        System.out.println("\n----------------------------------------------");
        System.out.println("Registering UCE Candidate 2...");
        System.out.println("----------------------------------------------");
        UCECandidate uce2 = new UCECandidate(
                "Sarah Namukasa",
                "Gayaza High School",
                "Mukono Examination Centre",
                "English, Mathematics, History, Geography, Christian Religious Education"
        );
        uce2.displayDetails();
        registry.register(uce2);
        Student.printTotalRegistered();

        System.out.println("\n----------------------------------------------");
        System.out.println("Registering UCE Candidate 3 (auto-centre)...");
        System.out.println("----------------------------------------------");
        // Using base Student constructor overload (auto-assigns centre)
        UCECandidate uce3 = new UCECandidate(
                "David Ssemakula",
                "Ntare School",
                "Kampala Examination Centre",
                "English, Mathematics, Physics, Technical Drawing, Computer Studies"
        );
        uce3.displayDetails();
        registry.register(uce3);
        Student.printTotalRegistered();

        // ---- UACE Candidates ---------------------------------------
        System.out.println("\n----------------------------------------------");
        System.out.println("Registering UACE Candidate 1...");
        System.out.println("----------------------------------------------");
        UACECandidate uace1 = new UACECandidate(
                "Grace Atukunda",
                "St. Mary's College Kisubi",
                "Entebbe Examination Centre",
                "Physics, Chemistry, Mathematics",
                "General Paper, ICT"
        );
        uace1.displayDetails();
        registry.register(uace1);
        Student.printTotalRegistered();

        System.out.println("\n----------------------------------------------");
        System.out.println("Registering UACE Candidate 2...");
        System.out.println("----------------------------------------------");
        UACECandidate uace2 = new UACECandidate(
                "Brian Ochieng",
                "King's College Budo",
                "Wakiso Examination Centre",
                "Economics, History, Entrepreneurship",
                "General Paper, French"
        );
        uace2.displayDetails();
        registry.register(uace2);
        Student.printTotalRegistered();

        // ---- Registry Summary --------------------------------------
        registry.printSummaryReport();

        System.out.println("==============================================");
        System.out.println("   Registration process completed.");
        System.out.println("==============================================");
    }
}
