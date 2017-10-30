package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;

public class UF implements Serializable, RenderizaCombo {

	private static final long serialVersionUID = 2886229510991159183L;
	
// declarar variaveis
	private Long codigo;
	private String siglaUF;
	private String nomeUF;
	
	// GET AND SETER
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getSiglaUF() {
		return siglaUF;
	}
	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}
	public String getNomeUF() {
		return nomeUF;
	}
	public void setNomeUF(String nomeUF) {
		this.nomeUF = nomeUF;
	}
	
	
	//
	
	@Override
	public String toString() {
		return this.nomeUF+"-"+this.siglaUF;
	}
	
	@Override
	public String getText() {
		return this.nomeUF;
	}

	public Long getCodigo1() {
		return codigo;
	}

	public void setCodigo1(Long codigoUF) {
		this.codigo = codigoUF;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UF other = (UF) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
