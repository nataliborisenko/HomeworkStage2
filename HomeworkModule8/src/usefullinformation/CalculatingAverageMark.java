package usefullinformation;
import universitystructure.*;
import java.util.*;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Stream;

public class CalculatingAverageMark {
    public static void studentAverageMarkForAllSubjects(Student student) {
        ArrayList<Integer> mark = new ArrayList<>(student.getStudentRecordBook().values());
        OptionalDouble averageMark = mark.stream()
                .mapToInt(integer -> Integer.valueOf(integer))
                .average();
        averageMark.ifPresent(value -> System.out.println("Student's average mark for all subjects is: " + value));
    }

    public static void averageMarkForSpecialSubjectInSpecialGroupOnSpecialFaculty(University university, NameOfFaculty nameOfFaculty, int numberOfGroup, Subjects subject) {
        List<Faculty> listOfFaculties = university.getListOfFaculties();
        OptionalDouble average = listOfFaculties.stream()
                .flatMap((Function<Faculty, Stream<Group>>) faculty -> faculty.getListOfGroups().stream())
                .filter(group -> group.getNumberOfGroup() == numberOfGroup)
                .flatMap((Function<Group, Stream<Student>>) group -> group.getStudents().stream())
                .filter(student -> student.getStudentRecordBook().containsKey(subject))
                .map(student -> student.getStudentRecordBook().getOrDefault(subject, 0))
                .mapToInt(integer -> Integer.valueOf(integer))
                .average();

        average.ifPresent(value -> System.out.println("The average mark for subject: " + subject + " on faculty: " + nameOfFaculty + " in group: " + numberOfGroup + " is: " + value));
    }

    public static void averageMarkForSpecialSubjectAtUniversity(University university, Subjects subject) {
        List<Faculty> listOfFaculties = university.getListOfFaculties();
        OptionalDouble average = listOfFaculties.stream()
                .flatMap((Function<Faculty, Stream<Group>>) faculty -> faculty.getListOfGroups().stream())
                .flatMap((Function<Group, Stream<Student>>) group -> group.getStudents().stream())
                .filter(student -> student.getStudentRecordBook().containsKey(subject))
                .map(student -> student.getStudentRecordBook().getOrDefault(subject, 0))
                .mapToInt(integer -> Integer.valueOf(integer))
                .average();
        average.ifPresent(value -> System.out.println("The average mark for subject: " + subject + " at the university is: " + value));
    }
}





