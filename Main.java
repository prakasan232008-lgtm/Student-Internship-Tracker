import java.util.ArrayList;
import java.io.*;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Skill> skills = new ArrayList<>();
    static ArrayList<Internship> internships = new ArrayList<>();

    static final String FILE_NAME = "student_data.txt";

    static Student findStudentById(int id) {

        for (Student student : students) {

            if (student.studentId == id) {
                return student;
            }
        }

        return null;
    }

    static void saveData() {

        try {

            PrintWriter writer =
                new PrintWriter(
                    new FileWriter(FILE_NAME)
                );

            writer.println("[STUDENTS]");

            for (Student student : students) {

                writer.println(
                    student.studentId + "|" +
                    student.name + "|" +
                    student.email + "|" +
                    student.department
                );
            }

            writer.println("[SKILLS]");

            for (Skill skill : skills) {

                writer.println(
                    skill.studentId + "|" +
                    skill.skillName + "|" +
                    skill.skillLevel
                );
            }

            writer.println("[INTERNSHIPS]");

            for (Internship internship : internships) {

                writer.println(
                    internship.studentId + "|" +
                    internship.companyName + "|" +
                    internship.role + "|" +
                    internship.status + "|" +
                    internship.duration
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                "Error saving data: " + e.getMessage()
            );
        }
    }

    static void loadData() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        students.clear();
        skills.clear();
        internships.clear();

        String section = "";

        try {

            BufferedReader reader =
                new BufferedReader(
                    new FileReader(file)
                );

            String line;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.equals("[STUDENTS]")) {
                    section = "STUDENTS";
                    continue;
                }

                if (line.equals("[SKILLS]")) {
                    section = "SKILLS";
                    continue;
                }

                if (line.equals("[INTERNSHIPS]")) {
                    section = "INTERNSHIPS";
                    continue;
                }

                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                try {

                    if (
                        section.equals("STUDENTS") &&
                        data.length >= 4
                    ) {

                        students.add(
                            new Student(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                data[3]
                            )
                        );
                    }

                    else if (
                        section.equals("SKILLS") &&
                        data.length >= 3
                    ) {

                        skills.add(
                            new Skill(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2]
                            )
                        );
                    }

                    else if (
                        section.equals("INTERNSHIPS") &&
                        data.length >= 5
                    ) {

                        internships.add(
                            new Internship(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                data[3],
                                Integer.parseInt(data[4])
                            )
                        );
                    }

                } catch (Exception ignored) {
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                "Error loading data: " + e.getMessage()
            );
        }
    }
}