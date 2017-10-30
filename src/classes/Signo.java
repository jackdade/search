package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;


public class Signo  implements Serializable, RenderizaCombo{

	private static final long serialVersionUID = 8736927633373213446L;

	//declarar variaveis
	private Long codigoo;
	private String nomeSigno;
	
	//getter and seters
	public Long getIdSigno() {
		return codigoo;
	}
	public void setIdSigno(Long idSigno) {
		this.codigoo = idSigno;
	}
	public String getNomeSigno() {
		return nomeSigno;
	}
	public void setNomeSigno(String nomeSigno) {
		this.nomeSigno = nomeSigno;
	}
	
	@Override
	public String toString() {
		return this.nomeSigno;
	}

	
	@Override
	public String getText() {
		return this.nomeSigno;
	}

	public Long getCodigo() {
		return codigoo;
	}

	public void setCodigo(Long idSigno) {
		this.codigoo = idSigno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoo == null) ? 0 : codigoo.hashCode());
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
		Signo other = (Signo) obj;
		if (codigoo == null) {
			if (other.codigoo != null)
				return false;
		} else if (!codigoo.equals(other.codigoo))
			return false;
		return true;
	}

	
	
	

	
}
