package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;


public class Cidade implements Serializable, RenderizaCombo {

	private static final long serialVersionUID = 5458079812824179266L;

	
	private Long Codigo;
	private String nomeCidade;
	private UF ufSelecionada;
	
	public Cidade() {
		
	}
	public Cidade(String nomeCidade){
		this.nomeCidade = nomeCidade;
		}
	
	//geter and seters
	public Long getCodigo() {
		return Codigo;
	}
	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public UF getUfSelecionada(UF uf) {
		return ufSelecionada;
	}
	public void setUfSelecionada(UF ufSelecionada) {
		this.ufSelecionada = ufSelecionada;
	}
	
	@Override
	public String toString() {
		return this.nomeCidade ;
	}

	public UF getUFSelecionada() {
		return ufSelecionada;
	}

	public void setAgenciaPreferencial(UF ufSelecionada) {
		this.ufSelecionada = ufSelecionada;
	}

	public Long getCodigo1() {
		return Codigo;
	}

	public void setCodigo1(Long codigo) {
		this.Codigo = codigo;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
