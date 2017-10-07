import java.text.DecimalFormat;
import java.util.*;


public class P06AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        enterStudentsAndGrades(scanner, studentsCount, studentsGrades);
        for (String student : studentsGrades.keySet()) {
            List<Double> grades = studentsGrades.get(student);
            double sum = 0;

            for (Double grade : grades) {
                sum += grade;
            }

            double count = grades.size();
            double average = sum / count;
            System.out.println(student + " is graduated with " + average);
        }
    }

    private static void enterStudentsAndGrades(Scanner scanner, int studentsCount, Map<String, List<Double>> studentsGrades) {
        for (int count = 0; count < studentsCount; count++) {
            List<Double> grades = new ArrayList<>();
            String studentName = scanner.nextLine();
            double[] inputGrades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            for (double inputGrade : inputGrades) {
                grades.add(inputGrade);
            }

            studentsGrades.put(studentName, grades);
        }
    }
}
