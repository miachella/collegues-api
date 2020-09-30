package dev.hotel.web.reservations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dev.hotel.entite.Reservation;

public class CreerResaResponseDto extends CreerResaRequestDto {

	private UUID uuid;

	public CreerResaResponseDto(Reservation reservation) {
		this.uuid = reservation.getUuid();
		this.setDateDebut(reservation.getDateDebut());
		this.setDateFin(reservation.getDateFin());

		this.setClientId(reservation.getClient().getUuid());

		List<UUID> chambres = new ArrayList<>();

		for (int i = 0; i < reservation.getChambres().size(); i++) {
			chambres.add(reservation.getChambres().get(i).getUuid());
		}
		this.setChambres(chambres);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
