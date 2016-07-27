package br.edu.ifms.tcc.transport;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespostaTO {

	private boolean salvo;

	public boolean isSalvo() {
		return salvo;
	}

	public void setSalvo(boolean salvo) {
		this.salvo = salvo;
	}
	
	
}
