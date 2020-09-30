package dev.hotel.web.reservations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreerResaRequestDto {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private UUID clientId;
	private List<UUID> chambres = new ArrayList<>();

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public List<UUID> getChambres() {
		return chambres;
	}

	public void setChambres(List<UUID> chambres) {
		this.chambres = chambres;
	}

	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

}
