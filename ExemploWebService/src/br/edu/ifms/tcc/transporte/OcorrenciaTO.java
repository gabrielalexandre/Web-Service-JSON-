package br.edu.ifms.tcc.transporte;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OcorrenciaTO {

	private String nomeCidadao;
	private Date dataNascimento;
	private String cpf;
	private String nomeMae;
	private Double latitude;
	private Double longitude;
	private Date dataHorario;
	public String getNomeCidadao() {
		return nomeCidadao;
	}
	public void setNomeCidadao(String nomeCidadao) {
		this.nomeCidadao = nomeCidadao;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Date getDataHorario() {
		return dataHorario;
	}
	public void setDataHorario(Date dataHorario) {
		this.dataHorario = dataHorario;
	}
	
	
	
}
