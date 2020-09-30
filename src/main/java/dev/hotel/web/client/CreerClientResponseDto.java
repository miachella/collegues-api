package dev.hotel.web.client;

import java.util.UUID;

import dev.hotel.entite.Client;

public class CreerClientResponseDto extends CreerClientRequestDto {

	private UUID uuid;

	public CreerClientResponseDto(Client client) {
		this.uuid = client.getUuid();
		this.setNom(client.getNom());
		this.setPrenoms(client.getPrenoms());
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
