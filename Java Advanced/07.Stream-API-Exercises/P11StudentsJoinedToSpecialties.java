import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P11StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        enterSpecialties(bf, studentSpecialties);
        enterStudents(bf, students);

        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(student -> {
                    studentSpecialties.stream()
                            .filter(studentSpecialty
                                    -> studentSpecialty.getFacultyNumber().equalsIgnoreCase(student.getFacultyNumber()))
                            .forEach(speciality -> System.out.printf("%s %s %s%n"
                                    , student.getName(), student.getFacultyNumber(), speciality.getSpecialtyName()));
                });
    }

    private static void enterStudents(BufferedReader bf, List<Student> students) throws IOException {
        while (true) {
            String line = bf.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String facultyNumber = tokens[0];
            String studentName = tokens[1] + " " + tokens[2];
            Student student = new Student(studentName, facultyNumber);

            students.add(student);
        }
    }

    private static void enterSpecialties(BufferedReader bf, List<StudentSpecialty> studentSpecialties) throws IOException {
        while (true) {
            String line = bf.readLine();
            if ("Students:".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String specialty = tokens[0] + " " + tokens[1];
            String facultyNumber = tokens[2];
            StudentSpecialty studentSpecialty = new StudentSpecialty(specialty, facultyNumber);

            studentSpecialties.add(studentSpecialty);
        }
    }
}
