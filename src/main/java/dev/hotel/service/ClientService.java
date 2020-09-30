package dev.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> listerClients(Integer numeroPage, Integer taille) {
		return clientRepository.findAll(PageRequest.of(numeroPage, taille)).getContent();
	}

	public Optional<Client> recupererClient(UUID uuid) {
		return clientRepository.findById(uuid);
	}

	public Optional<Client> recupererClientByNom(String nom) {
		return clientRepository.findByNom(nom);
	}

	@Transactional
	public Client creerNouveauClient(String nom, String prenoms) {
		Client nouveauClient = new Client(nom, prenoms);
		return clientRepository.save(nouveauClient);
	}

}
