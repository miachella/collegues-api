package dev.collegues.web.collegues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@Transactional
@CrossOrigin
@RestController
@RequestMapping("collegues")
public class CollegueController {

	private CollegueService collegueService;

	public CollegueController(CollegueService collegueService) {
		super();
		this.collegueService = collegueService;
	}

	@GetMapping
	public List<CollegueGalerieDto> getAllCollegue() {
		List<CollegueGalerieDto> ListCollegues = new ArrayList<>();
		List<Collegue> list = collegueService.listerCollegues();
		for (Collegue c : list) {
			ListCollegues.add(new CollegueGalerieDto(c.getMatricule(), c.getPhotoUrl()));
		}
		return ListCollegues;
	}

	@GetMapping(params = { "nom" })
	public ResponseEntity<?> getCollegueFromNom(@RequestParam String nom) {

		List<Collegue> listCollegue = collegueService.recupererCollegueParNom(nom);
		List<String> listMatricules = new ArrayList<>();

		for (Collegue c : listCollegue) {
			listMatricules.add(c.getMatricule());
		}

		if (!listCollegue.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(listMatricules);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le nom fourni ne correspond à aucun collègue.");
		}
	}

	@GetMapping(params = { "matricule" })
	public ResponseEntity<?> getCollegueFromMatricule(@RequestParam String matricule) {

		Optional<Collegue> listCollegue = collegueService.recupererCollegueParMatricule(matricule);

		if (listCollegue.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(listCollegue.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Le matricule fourni ne correspond à aucun collègue.");
		}
	}

	@PutMapping(params = { "oldEmail", "newEmail" })
	public ResponseEntity<?> setCollegueByEmail(@RequestParam String oldEmail, @RequestParam String newEmail) {
		return null;

	}

	@PostMapping
	public CreerCollegueResponseDto creerNouveauCollegue(@RequestBody @Validated CreerCollegueRequestDto dto) {
		Collegue collegueCree = this.collegueService.creerCollegue(dto);

		return new CreerCollegueResponseDto(collegueCree.getMatricule());
	}

}
