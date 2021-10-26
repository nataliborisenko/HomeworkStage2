package universitystructure;

import listexceptions.NoStudentsInGroupException;
import usefullinformation.NameOfFaculty;
import java.util.*;

public class Group {
    NameOfFaculty nameOfFaculty;
    private int numberOfGroup;
    private List<Student> students;

    public Group(NameOfFaculty nameOfFaculty, int numberOfGroup, List<Student> students) {
        List<Student> sortedListOfStudents = sortStudentsAccordingGroup(numberOfGroup, students);
        try {
            if (sortedListOfStudents.isEmpty()) {
                throw new NoStudentsInGroupException("Group cannot be created without students");
            } else {
                this.nameOfFaculty = nameOfFaculty;
                this.numberOfGroup = numberOfGroup;
                this.students = sortedListOfStudents;
            }
        } catch (NoStudentsInGroupException e) {
            System.out.println(e.getMessage());
        }
    }

    public NameOfFaculty getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(NameOfFaculty nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static ArrayList<Student> sortStudentsAccordingGroup(int numberOfGroup, List<Student> students) {
        ArrayList<Student> studentsSpecialGroup = new ArrayList<>();
        for (Student groupStudents : students) {
            if (groupStudents.getNumberOfGroup() == numberOfGroup) {
                studentsSpecialGroup.add(groupStudents);
            }
        }
        return studentsSpecialGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return numberOfGroup == group.numberOfGroup && nameOfFaculty == group.nameOfFaculty && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfFaculty, numberOfGroup, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameOfFaculty=" + nameOfFaculty +
                ", numberOfGroup=" + numberOfGroup +
                ", students=" + students +
                '}';
    }
}