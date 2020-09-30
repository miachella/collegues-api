package dev.hotel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.exception.HotelException;
import dev.hotel.repository.ReservationsRepository;

@Service
public class ReservationsService {

	private ReservationsRepository resaRepo;
	private ClientService clientService;
	private ChambreService chambreService;

	public ReservationsService(ReservationsRepository resaRepo) {
		super();
		this.resaRepo = resaRepo;
	}

	public List<Reservation> listerReservations(int numeroPage, int taille) {

		return resaRepo.findAll(PageRequest.of(numeroPage, taille)).getContent();
	}

	@Transactional
	public Reservation creerNouvelleReservation(LocalDate dateDebut, LocalDate dateFin, UUID clientId,
			List<UUID> chambres) {
		List<String> messagesErreurs = new ArrayList<>();

		Optional<Client> client = clientService.recupererClient(clientId);

		if (!client.isPresent()) {
			messagesErreurs.add("L'uuid " + clientId + " ne correspond à aucun client");
		}

		List<Chambre> listChambres = new ArrayList<>();

		for (UUID uuid : chambres) {
			Optional<Chambre> optionalChambre = chambreService.recupererChambre(uuid);
			if (optionalChambre.isPresent()) {
				listChambres.add(optionalChambre.get());
			} else {
				messagesErreurs.add("L'uuid " + uuid + " ne correspond à aucune chambre");
			}

		}
		Reservation nouvelleResa = new Reservation(dateDebut, dateFin, client.get(), listChambres);

		if (!messagesErreurs.isEmpty()) {
			throw new HotelException(messagesErreurs);
		}

		return resaRepo.save(nouvelleResa);
	}

}
