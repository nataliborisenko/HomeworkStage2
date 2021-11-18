package hardcore.model;

import java.util.Objects;

public class GraphicsProcessingUnit {
    private String typeOfGPU;
    private String numberOfGPU;

    public GraphicsProcessingUnit(String typeOfGPU, String numberOfGPU) {
        this.typeOfGPU = typeOfGPU;
        this.numberOfGPU = numberOfGPU;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    @Override
    public String toString() {
        return "GraphicsProcessingUnit{" +
                "typeOfGPU='" + typeOfGPU + '\'' +
                ", numberOfGPU='" + numberOfGPU + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphicsProcessingUnit that = (GraphicsProcessingUnit) o;
        return Objects.equals(typeOfGPU, that.typeOfGPU) && Objects.equals(numberOfGPU, that.numberOfGPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfGPU, numberOfGPU);
    }
}