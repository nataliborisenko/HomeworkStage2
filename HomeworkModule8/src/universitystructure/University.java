package universitystructure;
import listexceptions.NoFacultiesInUniversityException;
import usefullinformation.NamesOfUniversity;

import java.util.*;

public class University {
    NamesOfUniversity nameOfUniversity;
    private List<Faculty> listOfFaculties;

    public University(NamesOfUniversity nameOfUniversity, List<Faculty> namesOfFaculties) {
        List<Faculty> sortedListOfFaculty = sortFacultiesAccordingNameOfUniversity(nameOfUniversity, namesOfFaculties);
        try {
            if (sortedListOfFaculty.isEmpty()) {
                throw new NoFacultiesInUniversityException("University cannot be created without faculties");
            } else {
                this.nameOfUniversity = nameOfUniversity;
                this.listOfFaculties = namesOfFaculties;
            }
        } catch (NoFacultiesInUniversityException e) {
            e.printStackTrace();
        }
    }

    public NamesOfUniversity getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(NamesOfUniversity nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    public List<Faculty> getListOfFaculties() {
        return listOfFaculties;
    }

    public void setListOfFaculties(List<Faculty> listOfFaculties) {
        this.listOfFaculties = listOfFaculties;
    }

    public static ArrayList<Faculty> sortFacultiesAccordingNameOfUniversity(NamesOfUniversity nameOfUniversity, List<Faculty> listOfFaculties) {
        ArrayList<Faculty> listOfFacultiesSpecialUniversity = new ArrayList<>();
        for (Faculty listOfFaculty : listOfFaculties) {
            if ((listOfFaculty.getNameOfUniversity()) == (nameOfUniversity)) {
                listOfFacultiesSpecialUniversity.add(listOfFaculty);
            }
        }
        return listOfFacultiesSpecialUniversity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return nameOfUniversity == that.nameOfUniversity && Objects.equals(listOfFaculties, that.listOfFaculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfUniversity, listOfFaculties);
    }

    @Override
    public String toString() {
        return "University{" +
                "nameOfUniversity=" + nameOfUniversity +
                ", listOfFaculties=" + listOfFaculties +
                '}';
    }
}