package de.awtools.textscanner;

import java.io.File;
import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class TextScanner {
    
    private TrainedDataProvider provider;

    public TextScanner(TrainedDataProvider provider) {
        this.provider = provider;
    }

    public String start(BufferedImage image) throws Exception {
        provider.download();

        File tmpFolder = LoadLibs.extractTessResources("win32-x86-64");
        System.setProperty("java.library.path", tmpFolder.getPath());

        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("deu");
        tesseract.setOcrEngineMode(1);
        tesseract.setDatapath(provider.getDataPath().toString());
         
        String result = tesseract.doOCR(image);
        return result;
    }


}
