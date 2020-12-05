package de.awtools.textscanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class TrainedDataProvider {

    private static final String REPOSITORY = "https://github.com/tesseract-ocr/tessdata/raw/master/";
    private static final String TRAINED_DATA_DEU = "deu.traineddata";

    public void download() {
        try {
            createDataDirectory();
            if (!Files.exists(Path.of(getDataPath().toString(), TRAINED_DATA_DEU))) {
                Path path = Path.of(getDataPath().toString(), TRAINED_DATA_DEU);
                download(path.toFile(), REPOSITORY, TRAINED_DATA_DEU);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    void createDataDirectory() throws IOException {
        if (!Files.exists(getDataPath())) {
            Files.createDirectory(getDataPath());
        }
    }

    public Path getDataPath() {
        return Path.of(System.getProperty("user.home"), ".tesseract");
    }

    void download(File outputFile, String repository, String data) throws Exception {
        StringBuilder sb = new StringBuilder(repository);
        if (!repository.endsWith("/")) {
            sb.append("/");
        }
        sb.append(data);

        URL website = new URL(sb.toString());
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

}
