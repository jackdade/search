package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Signo;



public class signoJDBC implements signoDAO{

	@Override
	public List<Signo> listar() {
		List<Signo> signos = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from signo";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Signo signo = new Signo();
				signo.setCodigo(rs.getLong("idSigno"));
				signo.setNomeSigno(rs.getString("nomeSigno"));
			
				signos.add(signo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signos;
	}
	
	
	@Override
	public Signo get(Long codigo) {
		Signo signo = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from signo where idSigno = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			signo = new Signo();
			signo.setCodigo(rs.getLong("idSigno"));
			signo.setNomeSigno(rs.getString("nomeSigno"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signo;
	}


	@Override
	public void inserir(Signo entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void alterar(Signo entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}
	
}
