package br.edu.ifms.tcc.client;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import br.edu.ifms.tcc.transport.OcorrenciaTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class OcorrenciaClient {
	
	public static final String RESTFUL_SERVICE_URI = "http://localhost:8080/ExemploWebService";
	
	public ClientResponse salvaOcorrencia(OcorrenciaTO ocorrencia) {
		WebResource recursoRestful = criaResource();
		ClientResponse resposta = recursoRestful.path("nova").type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, ocorrencia);
		return resposta;
	}

	public static void main(String[] args) {
		OcorrenciaTO ocorrenciaTO = new OcorrenciaTO();
		ocorrenciaTO.setCpf("21484814525");
		ocorrenciaTO.setNomeCidadao("Silvio da Silva");
		ocorrenciaTO.setNomeMae("Ana Maria da Silva");
		Calendar calendario = Calendar.getInstance();
		calendario.set(1987, 1, 12);
		Date dataNascimento = calendario.getTime();
		ocorrenciaTO.setDataNascimento(dataNascimento);
		ocorrenciaTO.setDataHorario(new Date());
		ocorrenciaTO.setLatitude(13.84);
		ocorrenciaTO.setLongitude(-12.98);
		OcorrenciaClient cliente = new OcorrenciaClient();
        cliente.salvaOcorrencia(ocorrenciaTO);
	}
	
	private WebResource criaResource() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		return client.resource(RESTFUL_SERVICE_URI).path("rest").path("ocorrencia");
	}

}
