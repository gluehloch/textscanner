package de.awtools.textscanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.ResponseEntity;
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

		return "redirect:/";
	}
	

}
