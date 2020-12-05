package de.awtools.textscanner;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

public class TextScannerTest {

    @Test
    public void start() throws Exception {
        TextScanner textScanner = new TextScanner(); 
        java.awt.image.BufferedImage image = ImageIO.read(TextScanner.class.getResourceAsStream("ocrexample.jpg"));
        System.out.println(textScanner.start(image));
    }
}
