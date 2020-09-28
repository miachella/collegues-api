package dev.collegues.web.collegues;

public class CreerCollegueResponseDto {

	private String matricule;

	public CreerCollegueResponseDto(String matricule) {
		super();
		this.matricule = matricule;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
