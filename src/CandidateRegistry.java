import java.util.ArrayList;

public class CandidateRegistry {

    private ArrayList<Student> candidates = new ArrayList<>();

    public void registerCandidate(Student student) {
        candidates.add(student);
        System.out.println("Candidate registered: " + student.candidateName);
    }

    public int getTotalCandidates() {
        return candidates.size();
    }

    public void printAllCandidates() {
        System.out.println("Total candidates: " + candidates.size());
        for (Student s : candidates) {
            System.out.println("- " + s.candidateName + " | " + s.schoolName);
        }
    }
}
