package de.awtools.textscanner;

import org.junit.jupiter.api.Test;

public class TrainedDataProviderTest {

    @Test
    void downloadTrainedData() {
        TrainedDataProvider provider = new TrainedDataProvider();
        provider.download();
    }
    
}
