package src;
public class Internship {

    int studentId;
    String companyName;
    String role;
    String status;
    int duration;

    Internship(
        int studentId,
        String companyName,
        String role,
        String status,
        int duration
    ) {
        this.studentId = studentId;
        this.companyName = companyName;
        this.role = role;
        this.status = status;
        this.duration = duration;
    }
}