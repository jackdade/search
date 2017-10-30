package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.UF;


public class UFJDBC implements UFDao{

	@Override
	public List<UF> listar() {
		List<UF> ufs = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from UF";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UF uf = new UF();
				uf.setCodigo(rs.getLong("idUF"));
				uf.setNomeUF(rs.getString("nomeUF"));
				uf.setSiglaUF(rs.getString("siglaUF"));
				
				ufs.add(uf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ufs;
	}
	
	@Override
	public UF get(Long codigo) {
		UF uf = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from UF where idUF=" + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			uf = new UF();
			uf.setCodigo(rs.getLong("idUF"));
			uf.setNomeUF(rs.getString("nomeUF"));
			uf.setSiglaUF(rs.getString("siglaUF"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uf;
	}
	
	@Override
	public void inserir(UF entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void alterar(UF entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}


	
}
