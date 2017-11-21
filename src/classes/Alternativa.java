package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;

public class Alternativa implements Serializable, RenderizaCombo{

	
	private static final long serialVersionUID = -2594599746346031551L;
	
	private Long Codigo;
	private String Alternativa;
	private Respostas respota;
	public Long getCodigo() {
		return Codigo;
	}
	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}
	public String getAlternativa() {
		return Alternativa;
	}
	public void setAlternativa(String alternativa) {
		Alternativa = alternativa;
	}
	public Respostas getRespota() {
		return respota;
	}
	public void setRespota(Respostas respota) {
		this.respota = respota;
	}
	
	@Override
	public String toString() {
		return this.Alternativa;
	}
	
	public Respostas getresposta() {
		return respota;
	}

	public void setresposta(Respostas respostas) {
		this.respota = respostas;
	}
	
	public Long getCodigo1() {
		return Codigo;
	}

	public void setCodigo1(Long idJogador) {
		this.Codigo = idJogador;
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
		Alternativa other = (Alternativa) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

}
