package universitystructure;
import listexceptions.NoFacultiesInUniversityException;
import usefullinformation.NamesOfUniversity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class University {
    NamesOfUniversity nameOfUniversity;
    private List<Faculty> namesOfFaculties;

    public University(NamesOfUniversity nameOfUniversity, List<Faculty> namesOfFaculties) {
        List<Faculty> sortedListOfFaculty = sortFacultiesAccordingNameOfUniversity(nameOfUniversity, namesOfFaculties);
        try {
            if (sortedListOfFaculty.isEmpty()) {
                throw new NoFacultiesInUniversityException("University cannot be created without groups");
            } else {
                this.nameOfUniversity = nameOfUniversity;
                this.namesOfFaculties = namesOfFaculties;
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

    public List<Faculty> getNamesOfFaculties() {
        return namesOfFaculties;
    }

    public void setNamesOfFaculties(List<Faculty> namesOfFaculties) {
        this.namesOfFaculties = namesOfFaculties;
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
        return nameOfUniversity == that.nameOfUniversity && Objects.equals(namesOfFaculties, that.namesOfFaculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfUniversity, namesOfFaculties);
    }

    @Override
    public String toString() {
        return "University{" +
                "nameOfUniversity=" + nameOfUniversity +
                ", namesOfFaculties=" + namesOfFaculties +
                '}';
    }
}
