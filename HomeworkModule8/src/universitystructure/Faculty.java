package universitystructure;

import listexceptions.NoGroupsInFacultyException;
import usefullinformation.*;

import java.util.*;

public class Faculty {
    NamesOfUniversity nameOfUniversity;
    NameOfFaculty nameOfFaculty;
    private List<Group> listOfGroups;

    public Faculty(NamesOfUniversity nameOfUniversity, NameOfFaculty facultyName, List<Group> listOfGroups) {
        List<Group> sortedListOfGroups = sortGroupsAccordingNameOfFaculty(facultyName, listOfGroups);
        try {
            if (sortedListOfGroups.isEmpty()) {
                throw new NoGroupsInFacultyException("Faculty cannot be created without groups");
            } else {
                this.nameOfUniversity = nameOfUniversity;
                this.nameOfFaculty = facultyName;
                this.listOfGroups = sortedListOfGroups;
            }
        } catch (NoGroupsInFacultyException e) {
            e.printStackTrace();
        }
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

    public List<Group> getListOfGroups() {
        return listOfGroups;
    }

    public void setListOfGroups(List<Group> listOfGroups) {
        this.listOfGroups = listOfGroups;
    }

    public static ArrayList<Group> sortGroupsAccordingNameOfFaculty(NameOfFaculty facultyName, List<Group> listOfGroups) {
        ArrayList<Group> listOfGroupsSpecialFaculty = new ArrayList<>();
        for (Group listOfGroup : listOfGroups) {
            if ((listOfGroup.getNameOfFaculty()) == (facultyName)) {
                listOfGroupsSpecialFaculty.add(listOfGroup);
            }
        }
        return listOfGroupsSpecialFaculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return nameOfUniversity == faculty.nameOfUniversity && nameOfFaculty == faculty.nameOfFaculty && Objects.equals(listOfGroups, faculty.listOfGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfUniversity, nameOfFaculty, listOfGroups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "nameOfUniversity=" + nameOfUniversity +
                ", nameOfFaculty=" + nameOfFaculty +
                ", listOfGroups=" + listOfGroups +
                '}';
    }
}
