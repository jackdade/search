package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;

public class Pergunta implements Serializable, RenderizaCombo{
	
	private static final long serialVersionUID = -4286224179376779487L;
	private Long Codigo;
	private String peguntas;
	
	
	//geter and seters
	public Long getCodigo() {
		return Codigo;
	}
	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}
	public String getPeguntas() {
		return peguntas;
	}
	public void setPeguntas(String peguntas) {
		this.peguntas = peguntas;
	}
	
	
	// 
	@Override
	public String toString() {
		return this.peguntas ;
	}
	
	
	@Override
	public String getText() {
		return this.peguntas;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
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
		Pergunta other = (Pergunta) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}
	

}
