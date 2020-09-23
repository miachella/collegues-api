package dev.collegues.web.collegues;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@RestController
@RequestMapping("collegues")
public class CollegueController {

	private CollegueService collegueService;

	public CollegueController(CollegueService collegueService) {
		super();
		this.collegueService = collegueService;
	}

	@GetMapping
	public List<Collegue> getAllCollegue() {
		return collegueService.listerCollegues();
	}

	@GetMapping(params = { "nom" })
	public ResponseEntity<?> getEntrepriseFromId(@RequestParam String nom) {

		List<Collegue> listCollegue = collegueService.recupererCollegueParNom(nom);
		List<CollegueDto> listDto = new ArrayList<>();

		for (Collegue c : listCollegue) {
			listDto.add(new CollegueDto(c.getMatricule()));
		}

		if (!listCollegue.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(listDto);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le nom fourni ne correspond à aucun collègue.");
		}
	}

}
