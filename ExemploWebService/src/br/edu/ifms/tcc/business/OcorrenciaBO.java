package br.edu.ifms.tcc.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.tcc.dao.OcorrenciaDAO;
import br.edu.ifms.tcc.model.Cidadao;
import br.edu.ifms.tcc.model.Ocorrencia;
import br.edu.ifms.tcc.transport.OcorrenciaTO;
import br.edu.ifms.tcc.transport.RespostaTO;

public class OcorrenciaBO {

	public RespostaTO salva(OcorrenciaTO ocorrenciaTO) {
		Ocorrencia ocorrencia = converte(ocorrenciaTO);
		RespostaTO resposta = new RespostaTO();
		OcorrenciaDAO dao = new OcorrenciaDAO();
		resposta.setSalvo(dao.salva(ocorrencia));
		return resposta;
	}
	
	public List<OcorrenciaTO> buscaOcorrencias() {
		OcorrenciaDAO dao = new OcorrenciaDAO();
		List<Ocorrencia> ocorrencias = dao.recuperaTodos();
		return converteLista(ocorrencias);
	}
	
	private List<OcorrenciaTO> converteLista(List<Ocorrencia> ocorrencias) {
		List<OcorrenciaTO> ocorrenciasTO = new ArrayList<>();
		for(Ocorrencia ocorrencia : ocorrencias) {
			ocorrenciasTO.add(converte(ocorrencia));
		}
		return ocorrenciasTO;
	}
	
	private Ocorrencia converte(OcorrenciaTO ocorrenciaTO) {
		Ocorrencia ocorrencia = new Ocorrencia();
		
		Cidadao cidadao = new Cidadao();
		cidadao.setCpf(ocorrenciaTO.getCpf());
		cidadao.setDataNascimento(ocorrenciaTO.getDataNascimento());
		cidadao.setNome(ocorrenciaTO.getNomeCidadao());
		cidadao.setNomeMae(ocorrenciaTO.getNomeMae());
		
		ocorrencia.setCidadao(cidadao);
		ocorrencia.setDataHorario(ocorrenciaTO.getDataHorario());
		ocorrencia.setLatitude(ocorrenciaTO.getLatitude());
		ocorrencia.setLongitude(ocorrenciaTO.getLongitude());
		
		return ocorrencia;
	}
	
	private OcorrenciaTO converte(Ocorrencia ocorrencia) {
		OcorrenciaTO ocorrenciaTO = new OcorrenciaTO();
		ocorrenciaTO.setCpf(ocorrencia.getCidadao().getCpf());
		ocorrenciaTO.setNomeCidadao(ocorrencia.getCidadao().getNome());
		ocorrenciaTO.setNomeMae(ocorrencia.getCidadao().getNomeMae());
		ocorrenciaTO.setDataNascimento(ocorrencia.getCidadao().getDataNascimento());
		ocorrenciaTO.setDataHorario(ocorrencia.getDataHorario());
		ocorrenciaTO.setLatitude(ocorrencia.getLatitude());
		ocorrenciaTO.setLongitude(ocorrencia.getLongitude());
		return ocorrenciaTO;
	}
}
