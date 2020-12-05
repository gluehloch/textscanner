package de.awtools.textscanner;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class TextScanner {
    
    public String start(BufferedImage image) throws Exception {
        File tmpFolder = LoadLibs.extractTessResources("win32-x86-64");
        System.setProperty("java.library.path", tmpFolder.getPath());

        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("deu");
        tesseract.setOcrEngineMode(1);
         
        Path dataDirectory = Paths.get(ClassLoader.getSystemResource("de/awtools/textscanner").toURI());
        tesseract.setDatapath(dataDirectory.toString());
         
        String result = tesseract.doOCR(image);
        return result;
    }


}
