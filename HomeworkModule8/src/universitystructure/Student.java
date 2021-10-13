package universitystructure;

import usefullinformation.*;
import java.util.HashMap;
import java.util.Objects;


public class Student {
    private String surname;
    private String name;
    NamesOfUniversity nameOfUniversity;
    NameOfFaculty nameOfFaculty;
    private int numberOfGroup;
    Subjects subject1, subject2, subject3;
    private Integer markForSubject1, markForSubject2, markForSubject3;
    HashMap<Subjects, Integer> studentRecordBook;

    public Student(String surname, String name, NamesOfUniversity nameOfUniversity, NameOfFaculty nameOfFaculty, int numberOfGroup,
                   Subjects subject1, Integer markForSubject1, Subjects subject2, Integer markForSubject2, Subjects subject3, Integer markForSubject3) {
        this.surname = surname;
        this.name = name;
        this.nameOfUniversity = nameOfUniversity;
        this.nameOfFaculty = nameOfFaculty;
        this.numberOfGroup = numberOfGroup;
        try {
            if ((markForSubject1 < 0 | markForSubject2 < 0 | markForSubject3 < 0) |
                    (markForSubject1 > 10 | markForSubject2 > 10 | markForSubject3 > 10)) {
                throw new IllegalArgumentException("Mark cannot be less than 0 or more than 10. Please, enter the right mark");
            } else {
                try {
                    if (subject1 == null && subject2 == null && subject3 == null) {
                        throw new NullPointerException("Student can't study in University without subjects. Please, enter at least one subject");
                    } else {
                        this.studentRecordBook = studentRecordBookCreation(subject1, markForSubject1, subject2, markForSubject2, subject3, markForSubject3);
                    }
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamesOfUniversity getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(NamesOfUniversity nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
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

    public Subjects getSubject1() {
        return subject1;
    }

    public void setSubject1(Subjects subject1) {
        this.subject1 = subject1;
    }

    public Subjects getSubject2() {
        return subject2;
    }

    public void setSubject2(Subjects subject2) {
        this.subject2 = subject2;
    }

    public Subjects getSubject3() {
        return subject3;
    }

    public void setSubject3(Subjects subject3) {
        this.subject3 = subject3;
    }

    public Integer getMarkForSubject1() {
        return markForSubject1;
    }

    public void setMarkForSubject1(Integer markForSubject1) {
        this.markForSubject1 = markForSubject1;
    }

    public Integer getMarkForSubject2() {
        return markForSubject2;
    }

    public void setMarkForSubject2(Integer markForSubject2) {
        this.markForSubject2 = markForSubject2;
    }

    public Integer getMarkForSubject3() {
        return markForSubject3;
    }

    public void setMarkForSubject3(Integer markForSubject3) {
        this.markForSubject3 = markForSubject3;
    }

    public HashMap<Subjects, Integer> getStudentRecordBook() {
        return studentRecordBook;
    }

    public void setStudentRecordBook(HashMap<Subjects, Integer> studentRecordBook) {
        this.studentRecordBook = studentRecordBook;
    }

    public HashMap<Subjects, Integer> studentRecordBookCreation(Subjects subject1, Integer markForSubject1, Subjects subject2, Integer markForSubject2, Subjects subject3, Integer markForSubject3) {
        HashMap<Subjects, Integer> studentRecordBook = new HashMap<>();
        studentRecordBook.put(subject1, markForSubject1);
        studentRecordBook.put(subject2, markForSubject2);
        studentRecordBook.put(subject3, markForSubject3);
        return studentRecordBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numberOfGroup == student.numberOfGroup && Objects.equals(surname, student.surname) && Objects.equals(name, student.name) &&
                nameOfUniversity == student.nameOfUniversity && nameOfFaculty == student.nameOfFaculty && subject1 == student.subject1 && subject2 == student.subject2 &&
                subject3 == student.subject3 && Objects.equals(markForSubject1, student.markForSubject1) && Objects.equals(markForSubject2, student.markForSubject2) &&
                Objects.equals(markForSubject3, student.markForSubject3) && Objects.equals(studentRecordBook, student.studentRecordBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, nameOfUniversity, nameOfFaculty, numberOfGroup, subject1, subject2, subject3, markForSubject1, markForSubject2, markForSubject3, studentRecordBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", nameOfUniversity=" + nameOfUniversity +
                ", nameOfFaculty=" + nameOfFaculty +
                ", numberOfGroup=" + numberOfGroup +
                ", studentRecordBook=" + studentRecordBook +
                '}';
    }
}


