import universitystructure.*;
import usefullinformation.CalculatingAverageMark;

import static usefullinformation.NamesOfUniversity.*;
import static usefullinformation.NameOfFaculty.*;
import static usefullinformation.Subjects.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> listOfAllStudents = Arrays.asList(
                new Student("Petrov", "Petr", BSU, FACULTY_OF_BIOLOGY, 555, BIOLOGY, 10, HUMAN_ANATOMY, 10, PHYSICAL_EDUCATION, 3),
                new Student("Soroka", "Irina", BSU, FACULTY_OF_BIOLOGY, 554, BIOLOGY, 10, CHEMISTRY, 8, HUMAN_ANATOMY, 9),
                new Student("Sidorova", "Kate", BSU, FACULTY_OF_BIOLOGY, 554, BIOLOGY, 10, HUMAN_ANATOMY, 10, ENGLISH_LANGUAGE, 8),
                new Student("Makarenko", "Anna", BSU, FACULTY_OF_BIOLOGY, 555, BIOLOGY, 10, PHYSICAL_EDUCATION, 10, HUMAN_ANATOMY, 9),
                new Student("Sidorov", "Serge", BSU, FACULTY_OF_ECONOMICS, 333, ECONOMIC, 8, HISTORY, 10, PHYSICAL_EDUCATION, 10),
                new Student("Ivanov", "Ivan", BSU, FACULTY_OF_ECONOMICS, 335, ECONOMIC, 10, ENGLISH_LANGUAGE, 8, HISTORY, 8),
                new Student("Abramchic", "Kristina", BSU, FACULTY_OF_ECONOMICS, 334, ECONOMIC, 7, HISTORY, 10, PHYSICAL_EDUCATION, 9),
                new Student("Petrov", "Petr", BSU, FACULTY_OF_ECONOMICS, 334, ECONOMIC, 7, HISTORY, 8, ENGLISH_LANGUAGE, 6),
                new Student("Ivanova", "Rita", BSU, FACULTY_OF_INTERNATIONAL_RELATIONS, 222, ENGLISH_LANGUAGE, 8, HISTORY, 8, PHYSICAL_EDUCATION, 10),
                new Student("Volotovskaya", "Rita", BSU, FACULTY_OF_INTERNATIONAL_RELATIONS, 222, ENGLISH_LANGUAGE, 7, HISTORY, 9, PHYSICAL_EDUCATION, 10),
                new Student("Steseva", "Oksana", BSU, FACULTY_OF_INTERNATIONAL_RELATIONS, 222, ENGLISH_LANGUAGE, 10, HISTORY, 9, ECONOMIC, 10)
        );

        List<Group> listOfGroups = Arrays.asList(
                new Group(FACULTY_OF_BIOLOGY, 554, listOfAllStudents),
                new Group(FACULTY_OF_BIOLOGY, 555, listOfAllStudents),
                new Group(FACULTY_OF_ECONOMICS, 333, listOfAllStudents),
                new Group(FACULTY_OF_ECONOMICS, 334, listOfAllStudents),
                new Group(FACULTY_OF_INTERNATIONAL_RELATIONS, 222, listOfAllStudents));

        List<Faculty> listOfFaculties = Arrays.asList(
                new Faculty(BSU, FACULTY_OF_BIOLOGY, listOfGroups),
                new Faculty(BSU, FACULTY_OF_ECONOMICS, listOfGroups),
                new Faculty(BSU, FACULTY_OF_INTERNATIONAL_RELATIONS, listOfGroups));

        University university = new University(BSU, listOfFaculties);

        CalculatingAverageMark.studentAverageMarkForAllSubjects(listOfAllStudents.get(0));
        CalculatingAverageMark.averageMarkForSpecialSubjectInSpecialGroupOnSpecialFaculty(university, FACULTY_OF_INTERNATIONAL_RELATIONS, 222, ENGLISH_LANGUAGE);
        CalculatingAverageMark.averageMarkForSpecialSubjectAtUniversity(university, PHYSICAL_EDUCATION);
    }
}




