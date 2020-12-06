package de.awtools.textscanner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class Controller {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@PostMapping(value="/scan")
	public String scan(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {
		// ResponseEntity<>
		// return ResponseEntity.ok("text");
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + files[0].getOriginalFilename() + "!");

        System.out.println("File=" + files[0].getOriginalFilename());

        TrainedDataProvider provider = new TrainedDataProvider();
        TextScanner textScanner = new TextScanner(provider);

        Path tmpFile = null;
        String response = null;
        try {
            tmpFile = Files.createTempFile("textscanner", "tmp");
            files[0].transferTo(tmpFile.toFile());

            BufferedImage image = ImageIO.read(tmpFile.toFile());
            response = textScanner.start(image);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

		return response;
	}
	

}
