package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Alternativa;
import classes.Pergunta;

public class AlternativaJDBC implements alternativaDao{

	@Override
	public List<Alternativa> listar() {
		List<Alternativa> alternativas = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from alternativa";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Alternativa alternativa = new Alternativa();
				alternativa.setCodigo(rs.getLong("idAlternativa"));
				alternativa.setAlternativa(rs.getString("alternativa"));
				alternativas.add(alternativa);
				
				Pergunta pergunta = new Pergunta();
				pergunta.setCodigo(rs.getLong("idPergunta"));
				pergunta.setPeguntas(rs.getString("pergunta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alternativas;
	}
	
	
	@Override
	public Alternativa get(Long codigo) {
		Alternativa alternativa = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from alternativa where idAlternativa = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			alternativa = new Alternativa();
			alternativa.setCodigo(rs.getLong("idPergunta"));
			alternativa.setAlternativa(rs.getString("alternativa"));
			
			Pergunta pergunta = new Pergunta();
			pergunta.setCodigo(rs.getLong("idPergunta"));
			pergunta.setPeguntas(rs.getString("pergunta"));
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alternativa;
	}


	@Override
	public void inserir(Alternativa entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void alterar(Alternativa entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}
	
	
}
