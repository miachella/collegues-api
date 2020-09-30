package dev.hotel.web.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreerClientRequestDto {

	@NotBlank
	@Size(min = 2)
	private String nom;

	@NotBlank
	@Size(min = 3)
	private String prenoms;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

}
