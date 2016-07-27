package br.edu.ifms.tcc.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ifms.tcc.business.OcorrenciaBO;
import br.edu.ifms.tcc.transport.OcorrenciaTO;
import br.edu.ifms.tcc.transport.RespostaTO;

@Path("/ocorrencia")
public class OcorrenciaService {

	@POST
	@Path("/nova")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salva(OcorrenciaTO ocorrencia) {
		OcorrenciaBO bo = new OcorrenciaBO();
		RespostaTO resposta = bo.salva(ocorrencia);
		return Response.status(201).entity(resposta).build();		
	}
	
	@GET
	@Path("/todas")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<OcorrenciaTO> buscaOcorrencias() {
		OcorrenciaBO bo = new OcorrenciaBO();
		return bo.buscaOcorrencias();
	}
}
