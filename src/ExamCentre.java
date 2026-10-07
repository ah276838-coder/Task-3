public class ExamCentre {

    String centreName;
    String location;
    int capacity;
    int assignedStudents;

    ExamCentre(String centreName, String location, int capacity) {
        this.centreName = centreName;
        this.location = location;
        this.capacity = capacity;
        this.assignedStudents = 0;
        System.out.println("Exam Centre created: " + centreName);
    }

    public void assignStudent(Student student) {
        if (assignedStudents < capacity) {
            assignedStudents++;
            System.out.println(student.candidateName + " assigned to " + centreName);
        } else {
            System.out.println("Centre " + centreName + " is full. Cannot assign " + student.candidateName);
        }
    }

    public void displayCentreInfo() {
        System.out.println("Centre: " + centreName + " | Location: " + location + " | Slots left: " + (capacity - assignedStudents));
    }
}
