public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   UNEB CANDIDATE REGISTRATION SYSTEM");
        System.out.println("==============================================\n");

        System.out.println("Application started.");
        System.out.println("Loading examination configuration...\n");

        System.out.println("Current examination year: "
                + ExaminationSettings.examYear);

        System.out.println("\nCreating first candidate...\n");

        // First Student object
        Student student1 = new Student(
                "Zizi",
                "Makerere College School"
        );

        student1.displayDetails();

        System.out.println("\n----------------------------------------------");
        System.out.println("Creating second candidate...\n");

        // Second Student object
        Student student2 = new Student(
                "Faano",
                "Gariza High School"
        );

        student2.displayDetails();

        System.out.println("\n==============================================");
        System.out.println("Registration process completed.");
        System.out.println("==============================================");
    }
}