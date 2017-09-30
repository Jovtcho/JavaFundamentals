import java.util.*;
import java.util.stream.DoubleStream;


public class P01StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int studentsCount = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentsGrades = new TreeMap<>();

        enterStudentsAndGrades(scanner, studentsGrades);
        //enterStudentsAndGrades(scanner, studentsCount, studentsGrades);


        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));

        for (Map.Entry<String, double[]> entry : studentsGrades.entrySet()) {
            String currentStudentName = entry.getKey();
            double[] currentStudentGrades = entry.getValue();
            double jAdvGrade = currentStudentGrades[0];
            double jOopGrade = currentStudentGrades[1];
            double jAdvOopGrade = currentStudentGrades[2];
            double average = DoubleStream.of(currentStudentGrades).sum() / 3;

            System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                    currentStudentName, jAdvGrade, jOopGrade, jAdvOopGrade, average));
        }
    }

    private static void enterStudentsAndGrades(Scanner scanner, Map<String, double[]> studentsGrades) {
        String[] line = scanner.nextLine().split(" - ");
        String studentName = line[0];
        String allGrades = line[1];
        double[] grades = Arrays.stream(allGrades.split(", ")).mapToDouble(Double::parseDouble).toArray();
        studentsGrades.put(studentName, grades);
    }


    // private static void enterStudentsAndGrades(Scanner scanner, int studentsCount, Map<String, double[]> studentsGrades) {
    //     for (int count = 0; count < studentsCount; count++) {
    //         String[] line = scanner.nextLine().split(" - ");
    //         String studentName = line[0];
    //         String allGrades = line[1];
    //         double[] grades = Arrays.stream(allGrades.split(", ")).mapToDouble(Double::parseDouble).toArray();
    //         studentsGrades.put(studentName, grades);
    //     }
    // }
}
