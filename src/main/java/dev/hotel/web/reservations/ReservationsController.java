package dev.hotel.web.reservations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Reservation;
import dev.hotel.service.ReservationsService;

@RestController
public class ReservationsController {

	private ReservationsService resaService;

	public ReservationsController(ReservationsService resaService) {
		super();
		this.resaService = resaService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "reservations")
	public List<Reservation> listReservation(@RequestParam int start, @RequestParam int size) {
		return resaService.listerReservations(start, size);
	}

	@PostMapping(path = "reservations", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> postResa(@RequestBody CreerResaRequestDto resa) {

		return ResponseEntity.ok(new CreerResaResponseDto(resaService.creerNouvelleReservation(resa.getDateDebut(),
				resa.getDateFin(), resa.getClientId(), resa.getChambres())));

	}

}
