public class ExamCentre {

    String centreName;
    String location;
    int capacity;

    ExamCentre(String centreName, String location, int capacity) {
        this.centreName = centreName;
        this.location = location;
        this.capacity = capacity;
        System.out.println("Exam Centre created: " + centreName);
    }
}
