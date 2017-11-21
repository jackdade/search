package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Pergunta;


public class PerguntaJdbc implements perguntaDAO{

	@Override
	public List<Pergunta> listar() {
		List<Pergunta> perguntas = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from perguntas";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pergunta pergunta = new Pergunta();
				pergunta.setCodigo(rs.getLong("idPergunta"));
				pergunta.setPeguntas(rs.getString("pergunta"));
			
				perguntas.add(pergunta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perguntas;
	}
	
	
	@Override
	public Pergunta get(Long codigo) {
		Pergunta pergunta = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from perguntas where idPergunta = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			pergunta = new Pergunta();
			pergunta.setCodigo(rs.getLong("idPergunta"));
			pergunta.setPeguntas(rs.getString("pergunta"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pergunta;
	}


	


	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void inserir(Pergunta entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void alterar(Pergunta entidade) {
		// TODO Auto-generated method stub
		
	}
}
