package classes;

import java.io.Serializable;

import Componente.RenderizaCombo;

public class Login implements Serializable, RenderizaCombo {

	private static final long serialVersionUID = 4731694336222489794L;

	
	
	private Long codigo;
	private String username;
	private String senha;
	
	private Jogador jogador;


	//geter and seters
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	// to String
	@Override
	public String toString() {
		return this.username;
	}
	
	public Jogador getjogador() {
		return jogador;
	}
	
	public Jogador setjogador(Jogador jogador) {
		return this.jogador = jogador;
	}
	
	public Long getCodigo1() {
		return codigo;
	}

	public void setCodigo1(Long idJogador) {
		this.codigo = idJogador;
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
		Login other = (Login) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
