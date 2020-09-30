package dev.hotel.web.client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;

@RestController
public class ClientController {

	private ClientService clientService;

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "clients")
	public List<Client> listClient(@RequestParam int start, @RequestParam int size) {
		return clientService.listerClients(start, size);

	}

	@RequestMapping(method = RequestMethod.GET, path = "clients/{uuid}")
	public ResponseEntity<?> recupererClient(@PathVariable UUID uuid) {
		Optional<Client> optClient = clientService.recupererClient(uuid);

		if (optClient.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optClient);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez entrer un autre identifiant client");
		}

	}

	@RequestMapping(method = RequestMethod.GET, path = "clients/{nom}")
	public ResponseEntity<?> recupererClientByNom(@PathVariable String nom) {
		Optional<Client> optClient = clientService.recupererClientByNom(nom);

		if (optClient.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optClient);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez entrer un autre identifiant client");
		}

	}

	@PostMapping(path = "clients", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> postClient(@RequestBody @Valid CreerClientRequestDto client,
			BindingResult resultatValidation) {

		if (resultatValidation.hasErrors()) {
			return ResponseEntity.badRequest()
					.body("Erreur : la donnée n'a pas pu être rentrée en base à cause d'un nom/prénom trop court");
		}

		return ResponseEntity
				.ok(new CreerClientResponseDto(clientService.creerNouveauClient(client.getNom(), client.getPrenoms())));

	}

}
