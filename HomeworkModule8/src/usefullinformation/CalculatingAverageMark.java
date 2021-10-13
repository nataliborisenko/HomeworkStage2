package usefullinformation;
import universitystructure.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatingAverageMark {
    public static void studentAverageMarkForAllSubjects(Student student) {
        int sumOfMarks = 0, averageMark = 0;
        ArrayList<Integer> mark = new ArrayList<>(student.getStudentRecordBook().values());
        for (Integer marks : mark) {
            sumOfMarks += marks;
            averageMark = sumOfMarks / mark.size();

        }
        System.out.println("Student's average mark for all subjects is: " + averageMark);
    }

    public static void averageMarkForSpecialSubjectInSpecialGroupOnSpecialFaculty(List<Group> listOfGroups, NameOfFaculty nameOfFaculty, int numberOfGroup, Subjects subject) {
        int sumOfMarks = 0, countNumbers = 0;
        for (Group group : listOfGroups) {
            if (group.getNameOfFaculty() == nameOfFaculty & group.getNumberOfGroup() == numberOfGroup) {
                for (Student student : group.getStudents()) {
                    if (student.getStudentRecordBook().containsKey(subject)) {
                        sumOfMarks += student.getStudentRecordBook().get(subject);
                        countNumbers++;
                    }
                }
            }
        }
        System.out.println("Average mark for subject: " + subject + " on faculty: " + nameOfFaculty + " in group: " + numberOfGroup + " is: " + sumOfMarks / countNumbers);
    }

    public static void averageMarkForSpecialSubjectInAllUniversity(List<Faculty> listOfFaculties, Subjects subject) {
        int sumOfMarks = 0, countNumbers = 0;
        for (Faculty faculty : listOfFaculties) {
            for (Group group : faculty.getListOfGroups()) {
                for (Student student : group.getStudents()) {
                    if (student.getStudentRecordBook().containsKey(subject)) {
                        sumOfMarks += student.getStudentRecordBook().get(subject);
                        countNumbers++;
                    }
                }
            }
        }
        System.out.println("Average mark for subject: " + subject + " in University is: "+ sumOfMarks / countNumbers);
    }
}




