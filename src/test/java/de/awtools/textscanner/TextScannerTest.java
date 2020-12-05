package de.awtools.textscanner;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

public class TextScannerTest {

    @Test
    public void start() throws Exception {
        TrainedDataProvider provider = new TrainedDataProvider();
        TextScanner textScanner = new TextScanner(provider); 
        java.awt.image.BufferedImage image = ImageIO.read(TextScanner.class.getResourceAsStream("ocrexample.jpg"));
        System.out.println(textScanner.start(image));
    }

    @Test
    public void scanImage() throws Exception {
        TrainedDataProvider provider = new TrainedDataProvider();
        TextScanner textScanner = new TextScanner(provider); 
        java.awt.image.BufferedImage image = ImageIO.read(TextScanner.class.getResourceAsStream(".rechnung-zahnarzt.jpg"));
        System.out.println(textScanner.start(image));
    }

}
