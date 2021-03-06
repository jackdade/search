


package bancoDeDados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Cidade;
import classes.Jogador;
import classes.Signo;


public class jogadorJDBC implements jogadorDAO {

	@Override
	public void inserir(Jogador jogador) {
		try {
		Connection con = ConexaoUtil.getCon();
		String insert = "insert into jogador values(idJogador,?,?,?,?,?,?,?,?,?)";
		PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
		insertStmt.setString(1, jogador.getNomeJogador());
		insertStmt.setString(7, jogador.getSobrenome());
		insertStmt.setString(6, jogador.getSexo());
		insertStmt.setString(2, jogador.getCPF());
		insertStmt.setDate(3, Date.valueOf(jogador.getIdade()));
		insertStmt.setLong(5, jogador.getSigno().getCodigo());
		insertStmt.setLong(4, jogador.getCidade().getCodigo());
		insertStmt.setString(8, jogador.getUsername());
		insertStmt.setString(9, jogador.getSenha());
		insertStmt.executeUpdate();
		ResultSet resultSet = insertStmt.getGeneratedKeys();
		resultSet.next();
		jogador.setCodigo(resultSet.getLong(1));
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	}
	


		
	

	@Override
	public void alterar(Jogador jogador) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update jogador set nomeJogador = ?, " + "sobrenome = ?, sexo=?, cpf = ?, idade = ?, idSigno = ?, idCidade=?, username=?, senha=?,"
					+ " where idJogador = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setString(1, jogador.getNomeJogador());
			updateStmt.setString(7, jogador.getSobrenome());
			updateStmt.setString(6, jogador.getSexo());
			updateStmt.setString(2, jogador.getCPF());
			updateStmt.setDate(3, Date.valueOf(jogador.getIdade()));
			updateStmt.setLong(5, jogador.getSigno().getCodigo());
			updateStmt.setLong(4, jogador.getCidade().getCodigo());
			updateStmt.setString(8, jogador.getUsername());
			updateStmt.setString(9, jogador.getSenha());
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from jogador where idJogador = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Jogador> listar() {
		List<Jogador> jogadores = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL                       
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select cidade*from jogador";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Jogador jogador = new Jogador();
				jogador.setCodigo(rs.getLong("idJogador"));
				jogador.setNomeJogador(rs.getString("nomeJogador"));
				jogador.setSobrenome(rs.getString("sobrenome"));
				jogador.setCPF(rs.getString("cpf"));
				jogador.setIdade(rs.getDate("idade").toLocalDate());
				jogador.setSexo(rs.getString("sexo"));
				jogador.setSenha(rs.getString("senha"));
				jogador.setUsername(rs.getString("username"));
				
				
				Cidade Cidade= new Cidade();
				jogador.setCodigo(rs.getLong("idCidade"));
				jogador.setCidade(Cidade);
				jogadores.add(jogador);
				
				
				Signo Signo = new Signo();
				jogador.setCodigo(rs.getLong("idSigno"));
				jogador.setSigno(Signo);
				jogadores.add(jogador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogadores;
	}

	@Override
	public Jogador get(Long codigo) {
		Jogador jogador = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from jogador where idJogador=" + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			
			jogador = new Jogador();
			jogador.setCodigo(rs.getLong("idJogador"));
			jogador.setNomeJogador(rs.getString("nomeJogador"));
			jogador.setSobrenome(rs.getString("sobrenome"));
			jogador.setCPF(rs.getString("cpf"));
			jogador.setIdade(rs.getDate("idade").toLocalDate());
			jogador.setSexo(rs.getString("sexo"));
			jogador.setSenha(rs.getString("senha"));
			jogador.setUsername(rs.getString("username"));
			
			
			Cidade Cidade= new Cidade();
			jogador.setCodigo(rs.getLong("idCidade"));
			jogador.setCidade(Cidade);
		
			
			
			Signo Signo = new Signo();
			jogador.setCodigo(rs.getLong("idSigno"));
			jogador.setSigno(Signo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogador;
	}

}
