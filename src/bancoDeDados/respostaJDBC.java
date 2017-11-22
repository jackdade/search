package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Alternativa;

import classes.Jogador;
import classes.Pergunta;
import classes.Respostas;


public class respostaJDBC implements respostaDAO{

	
	@Override
	public void inserir(Respostas respostas) {
		try {
		Connection con = ConexaoUtil.getCon();
		String insert = "insert into respostas values(idRespostas,?,?,?)";
		PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
		insertStmt.setLong(1, respostas.getJogador().getCodigo());
		insertStmt.setLong(2, respostas.getPergunta().getCodigo());
		insertStmt.setLong(3, respostas.getAlternativa().getCodigo());
		
		insertStmt.executeUpdate();
		ResultSet resultSet = insertStmt.getGeneratedKeys();
		resultSet.next();
		respostas.setCodigo(resultSet.getLong(1));
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	}
	


		
	

	
	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from respostas where idRespostas = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Respostas> listar() {
		List<Respostas> respostas = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL                       
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from respostas";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Respostas resposta = new Respostas();
				resposta.setCodigo(rs.getLong("idRespostas"));
				respostas.add(resposta);
				
				Jogador jogador = new Jogador();
				jogador.setCodigo(rs.getLong("idJogador"));
				
				
				Alternativa alternativa = new Alternativa();
				alternativa.setCodigo(rs.getLong("idAlternativa"));
				
				
				
				Pergunta pergunta = new Pergunta();
				pergunta.setCodigo(rs.getLong("idPergunta"));
				pergunta.setPeguntas(rs.getString("pergunta"));
				
				respostas.add(resposta);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respostas;
	}

	@Override
	public Respostas get(Long codigo) {
		Respostas resposta = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from respostas where idRespostas=" + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			
			resposta = new Respostas();
			resposta.setCodigo(rs.getLong("idJogador"));
			
			
			
			Jogador jogador = new Jogador();
			jogador.setCodigo(rs.getLong("idJogador"));
			jogador.setNomeJogador(rs.getString("nomeJogador"));
			jogador.setSobrenome(rs.getString("sobrenome"));
			jogador.setCPF(rs.getString("cpf"));
			jogador.setIdade(rs.getDate("idade").toLocalDate());
			jogador.setSexo(rs.getString("sexo"));
			jogador.setSenha(rs.getString("senha"));
			jogador.setUsername(rs.getString("username"));
			
			
			Alternativa alternativa = new Alternativa();
			alternativa.setCodigo(rs.getLong("idAlternativa"));
			alternativa.setAlternativa(rs.getString("alternativa"));
			
			
			Pergunta pergunta = new Pergunta();
			pergunta.setCodigo(rs.getLong("idPergunta"));
			pergunta.setPeguntas(rs.getString("pergunta"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}







	@Override
	public void alterar(Respostas entidade) {
		// TODO Auto-generated method stub
		
	}
}
