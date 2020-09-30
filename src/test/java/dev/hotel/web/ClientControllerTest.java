package dev.hotel.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;
import dev.hotel.web.client.ClientController;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClientService clientService;

	@Test
	void testListClient() throws Exception {

		Client client = new Client("Boop", "Betty");
		Client client2 = new Client("Rabbit", "Roger");

		Mockito.when(clientService.listerClients(0, 2)).thenReturn(Arrays.asList(client, client2));

		mockMvc.perform(MockMvcRequestBuilders.get("/clients?start=0&size=2")).andExpect(status().isOk())
				.andExpect(jsonPath("[0].nom").value("Boop")).andExpect(jsonPath("[0].prenoms").value("Betty"))
				.andExpect(jsonPath("[1].nom").value("Rabbit")).andExpect(jsonPath("[1].prenoms").value("Roger"));

	}

	@Test
	void testGetClientUUID() throws Exception {
		// get
		Client client = new Client("Boop", "Betty");
		UUID id = UUID.randomUUID();
		client.setUuid(id);
		// when
		Mockito.when(clientService.recupererClient(id)).thenReturn(Optional.of(client));
		// then
		mockMvc.perform(MockMvcRequestBuilders.get("/clients/{uuid}", id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.nom").value("Boop")).andExpect(jsonPath("$.prenoms").value("Betty"));
	}

	@Test
	void testPostClient() throws Exception {
		// get
		Client client = new Client();
		client.setNom("Rabbit");
		client.setPrenoms("Roger");
		// when
		Mockito.when(clientService.creerNouveauClient("Rabbit", "Roger")).thenReturn(client);
		// then

		mockMvc.perform((MockMvcRequestBuilders.post("/clients")).contentType(MediaType.APPLICATION_JSON)
				.content("{\"nom\": \"Rabbit\", \"prenoms\": \"Roger\" }").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
