package dev.collegues.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.collegues.entite.Collegue;
import dev.collegues.repository.CollegueRepository;
import dev.collegues.web.collegues.CreerCollegueRequestDto;

@Service
public class CollegueService {

	private CollegueRepository collegueRepository;

	public CollegueService(CollegueRepository collegueRepository) {
		super();
		this.collegueRepository = collegueRepository;
	}

	public List<Collegue> listerCollegues() {
		return collegueRepository.findAll();
	}

	public List<Collegue> recupererCollegueParNom(String nom) {
		return collegueRepository.findByNom(nom);
	}

	public Optional<Collegue> recupererCollegueParMatricule(String matricule) {
		return collegueRepository.findByMatricule(matricule);
	}

	public Collegue creerCollegue(CreerCollegueRequestDto collegueRequestDto) {

		Collegue collegue = new Collegue();
		collegue.setNom(collegueRequestDto.getNom());
		collegue.setPrenoms(collegueRequestDto.getPrenoms());
		collegue.setDateDeNaissance(collegueRequestDto.getDateDeNaissance());
		collegue.setPhotoUrl(collegueRequestDto.getPhotoUrl());

		// logique métier (génération du matricule)
		collegue.setMatricule("Matricule" + Math.floor(Math.random() * 100));

		return this.collegueRepository.save(collegue);

	}

}
