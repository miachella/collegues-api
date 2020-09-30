package dev.hotel.service;

import java.util.Optional;
import java.util.UUID;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;

public class ChambreService {

	private ChambreRepository chambreRepository;

	public ChambreService(ChambreRepository chambreRepository) {
		super();
		this.chambreRepository = chambreRepository;
	}

	public Optional<Chambre> recupererChambre(UUID uuid) {
		return chambreRepository.findById(uuid);
	}

}
