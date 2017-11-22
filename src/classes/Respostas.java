package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;

public class Respostas implements Serializable, RenderizaCombo {

	private static final long serialVersionUID = -7954459225078871120L;
	
	private Long Codigo;
	private Pergunta pergunta;
	private Alternativa alternativa;
	private Jogador jogador;
	
	
	
	
	
	
	
	
	
	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
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
		Respostas other = (Respostas) obj;
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
