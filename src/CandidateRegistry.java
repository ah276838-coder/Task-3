import java.util.ArrayList;

public class CandidateRegistry {

    private ArrayList<Student> candidates = new ArrayList<>();

    public void registerCandidate(Student student) {
        candidates.add(student);
        System.out.println("Candidate registered: " + student.candidateName);
    }
}
