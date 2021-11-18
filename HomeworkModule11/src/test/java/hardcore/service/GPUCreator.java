package hardcore.service;

import hardcore.model.GraphicsProcessingUnit;

public class GPUCreator {
    private static final String TEST_DATA_TYPE_OF_GPU = "test.data.type.of.gpu";
    private static final String TEST_DATA_NUMBER_OF_GPU ="test.data.number.of.gpu";

    public static GraphicsProcessingUnit withCredentialsFromProperty(){
    return new GraphicsProcessingUnit(TestDataReader.getTestData(TEST_DATA_TYPE_OF_GPU),
            TestDataReader.getTestData(TEST_DATA_NUMBER_OF_GPU));
    }
    public static GraphicsProcessingUnit withEmptyTypeOfGPU() {return new GraphicsProcessingUnit("",TestDataReader.getTestData(TEST_DATA_NUMBER_OF_GPU));}

    public static GraphicsProcessingUnit withEmptyNumberOfGPU() {return new GraphicsProcessingUnit(TestDataReader.getTestData(TEST_DATA_TYPE_OF_GPU), "");}
}
