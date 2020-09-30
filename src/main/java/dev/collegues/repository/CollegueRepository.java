package dev.collegues.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.collegues.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Collegue> findByNom(String nom);

	@Modifying
	@Query("UPDATE Collegue c SET c.email = :newEmail WHERE c.email = :oldEmail")
	void changerEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);

	@Modifying
	@Query("UPDATE Collegue c SET c.photoUrl = :newPhotoUrl WHERE c.photoUrl = :oldPhotoUrl")
	void changerPhotoUrl(@Param("oldPhotoUrl") String oldPhotoUrl, @Param("newPhotoUrl") String newPhotoUrl);

	Optional<Collegue> findByMatricule(String matricule);

	Optional<Collegue> findByEmail(String email);

	Optional<Collegue> findByPhotoUrl(String photoUrl);

}
