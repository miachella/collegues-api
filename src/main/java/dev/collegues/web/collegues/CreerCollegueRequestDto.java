package dev.collegues.web.collegues;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

public class CreerCollegueRequestDto {

	@NonNull
	private String nom;
	@NonNull
	private String prenoms;
	@NonNull
	private String email;
	@NonNull
	private LocalDate dateDeNaissance;
	@NonNull
	private String photoUrl;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
